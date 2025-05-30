package com.application.topics.topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;
    List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("backend", "spring-boot-description", "spring-boot"),
            new Topic("fullstack", "spring-boot-description", "spring-boot"),
            new Topic("frontend", "spring-boot-description", "spring-boot")
    ));

    public List<Topic> getAllTopics() {

        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Optional<Topic> getTopic(String id) {
        return topicRepository.findById(id);
    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic) {
       topicRepository.save(topic);
        }

    public void deleteTopic(String id) {
        topicRepository.deleteById(id);
    }
}