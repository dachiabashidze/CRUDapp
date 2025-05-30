package com.application.topics.topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class TopicController {

    private final TopicService topicService;

    public TopicController(TopicService topicService){
        this.topicService=topicService;
    }
    @GetMapping("/topics")
    public List<Topic> getAllTopics(){
        return topicService.getAllTopics();
    }

    @GetMapping("/topics/{id}")
    public Optional<Topic> getTopic(@PathVariable String id){
        return topicService.getTopic(id);
    }

    @PostMapping("/topics")
    public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
    }

    @PutMapping("/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id){
        topicService.updateTopic(id,topic);
    }

    @DeleteMapping("/topics/{id}")
    public void deleteTopic(@PathVariable String id){
        topicService.deleteTopic(id);
    }
}
