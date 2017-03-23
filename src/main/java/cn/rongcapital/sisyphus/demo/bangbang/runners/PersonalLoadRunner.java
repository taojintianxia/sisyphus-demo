package cn.rongcapital.sisyphus.demo.bangbang.runners;

import static java.util.Arrays.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

import java.util.List;

import org.jbehave.core.io.StoryFinder;

import cn.rongcapital.sisyphus.base.BaseRunner;

/**
 * @author nianjun
 * 
 */

public class PersonalLoadRunner extends BaseRunner {

    @Override
    public String[] getStepsBasePackages() {
        return new String[] {"cn.rongcapital.sisyphus.demo.bangbang.steps"};
    }

    @Override
    public List<String> storyPaths() {
        String codeLocation = codeLocationFromClass(this.getClass()).getFile();
        return new StoryFinder().findPaths(codeLocation, asList("**/stories/**/personal_loan.story"), asList(""));
    }

}
