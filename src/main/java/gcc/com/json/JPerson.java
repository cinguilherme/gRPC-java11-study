package gcc.com.json;

import java.util.List;

public class JPerson {

    private String name;
    private Integer age;
    private List<String> tags;
    private List<Integer> favoriteNums;

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<Integer> getFavoriteNums() {
        return favoriteNums;
    }

    public void setFavoriteNums(List<Integer> favoriteNums) {
        this.favoriteNums = favoriteNums;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
