package br.com.unifacef.ijb.models.dtos;

public class EventDTO {

    private Long id;
    private String name;
    private String description;
    private String date;
    private String state;
    private String code;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
}
