package ua.com.foxminded.charcounter;

import java.util.Map;

public class DataSourceCache implements Cache {
    private Cache wrappee;
    
    public DataSourceCache(Cache source) {
        this.wrappee = source;
    }
    
    @Override
    public void addData(String data) {
        wrappee.addData(data);
    }

    @Override
    public Map<Character, Integer> getData(String text) {
        return wrappee.getData(text);
    }

}
