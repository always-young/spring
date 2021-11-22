package com.kevin.sourceaop;

/**
 * Code is far away from bug with the animal protecting
 *
 * @author kevin lau (双鹰)
 */
public class ConsoleMessageServiceImpl implements MessageService{
    @Override
    public void sendMessage(String message) {
        System.out.println(message);
    }
}
