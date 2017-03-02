package cn.rongcapital.sisyphus.demo.jd.runners;

import static java.util.Arrays.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

import java.util.List;

import org.jbehave.core.io.StoryFinder;

import cn.rongcapital.sisyphus.base.BaseRunner;

/**
 * @author nianjun
 * 
 */

public class JdDemoRunner extends BaseRunner {

    @Override
    protected String[] getStepsBasePackages() {
        return new String[] {"cn.rongcapital.sisyphus.demo.jd.steps"};
    }

    @Override
    
    protected List<String> storyPaths() {
        String codeLocation = codeLocationFromClass(this.getClass()).getFile();
        return new StoryFinder().findPaths(codeLocation, asList("**/stories/**/jddemo.story"), asList(""));
    }

}
