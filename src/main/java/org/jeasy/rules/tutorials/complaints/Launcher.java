
package org.jeasy.rules.tutorials.shop;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.mvel.MVELRule;
import org.jeasy.rules.mvel.MVELRuleFactory;
import org.jeasy.rules.support.reader.YamlRuleDefinitionReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Launcher {

    public static void main(String[] args) throws Exception {
        //create a person instance (fact)
        Complaint c1 = new Complaint("1","Timmies", "Stealing wages");
        Complaint c2 = new Complaint("2", "Timmies","Stealing wages");
        Complaint c3 = new Complaint("3", "Timmies","Stealing wages");
        List<Complaint> cList = new ArrayList<Complaint>();
        cList.add(c1);
        cList.add(c2);
        cList.add(c3);
        Facts facts = new Facts();
        facts.put("complaints", cList);
        // create rules
        MVELRuleFactory ruleFactory = new MVELRuleFactory(new YamlRuleDefinitionReader());
        String fileName = args.length != 0 ? args[0] : "C:\\Users\\TrimanSingh\\Documents\\DOLrule_easyrules\\src\\main\\java\\org\\jeasy\\rules\\tutorials\\complaints\\inspection-rule.yml";
        Rule inspectionRule = ruleFactory.createRule(new FileReader(fileName));

        // create a rule set
        Rules rules = new Rules();
        rules.register(inspectionRule);

        //create a default rules engine and fire rules on known facts
        RulesEngine rulesEngine = new DefaultRulesEngine();

        rulesEngine.fire(rules, facts);
    }

}
