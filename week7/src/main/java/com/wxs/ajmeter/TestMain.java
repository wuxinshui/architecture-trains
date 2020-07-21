package com.wxs.ajmeter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TestMain {

    private static Logger logger = LoggerFactory.getLogger(TestMain.class);


    public static void main(String[] args) throws Exception {
        int n = 100;
        int c = 10;
        String url = "https://api.github.com/users";
        AJMeter ajMeter = new AJMeter(n, c, url);

        List<AJResult> futureList = ajMeter.execute();
        futureList.forEach(o -> {
            logger.info("unionId:{},time:{},result:{}", o.getUnionId(), o.getTime(), o.getResult());
        });

        System.out.println(ajMeter.prettyResult(futureList));;

        System.exit(1);
    }


}
