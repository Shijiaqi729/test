package cn.skx.mavenSSM01.model;

import javax.persistence.Table;

@Table(name = "t_video")
public class Vedio {
    private int id;
    private String actor;
    private String name;
    private String pic;

    public Vedio() {
    }

    public Vedio(String actor, String name, String pic) {
        this.actor = actor;
        this.name = name;
        this.pic = pic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @Override
    public String toString() {
        return "Vedio{" +
                "id=" + id +
                ", actor='" + actor + '\'' +
                ", name='" + name + '\'' +
                ", pic='" + pic + '\'' +
                '}';
    }
}
