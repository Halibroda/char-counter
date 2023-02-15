package ua.com.foxminded.charcounter;

import java.util.Map;

public class DataCache extends DataSourceCache{

    public DataCache(Cache textData) {
        super(textData);
    }
    
    @Override
    public Map<Character, Integer> getData(String text) {
        if (super.getData(text) == null) {
            super.addData(text);
        }
        return super.getData(text);
    }
}
