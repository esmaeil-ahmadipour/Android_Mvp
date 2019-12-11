package ir.sample.mvpsample.Data;

public class News
{
    private  String id;
    private String title;
    private String description;
    private String image;
    private String video;
    private String date;

    public void setId(String id)
    {
        this.id = id;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

    public void setVideo(String video)
    {
        this.video = video;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public String getId()
    {
        return id;
    }

    public String getTitle()
    {
        return title;
    }

    public String getDescription()
    {
        return description;
    }

    public String getImage()
    {
        return image;
    }

    public String getVideo()
    {
        return video;
    }

    public String getDate()
    {
        return date;
    }
}
