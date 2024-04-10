package com.rmq.demo.utils;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


@Slf4j
@Component
public class Utils {

    public Locale getLocaleByLanguage(String language) {
        if (language == null || language.equals("0")) {
            return Locale.ENGLISH;
        }
        return Locale.FRENCH;
    }
}
