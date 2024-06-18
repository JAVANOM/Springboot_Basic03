package com.fastcampus.ch3.di3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("setting.properties")
public class SysInfo {

    @Value("#{systemProperties['user.timezone']}")
    String timeZone;
    @Value("#{systemEnvironment['Path']}")
    String currDir;
    @Value("${autosaveDir}")
    String autosaveDir;
    @Value("${autosaveInteval}")
    int autosaveInteval;
    @Value("${autosave}")
    boolean autosave;

    @Override
    public String toString() {
        return "SysInfo{" +
                "timeZone='" + timeZone + '\'' +
                ", currDir='" + currDir + '\'' +
                ", autosaveDir='" + autosaveDir + '\'' +
                ", autosaveInteval=" + autosaveInteval +
                ", autosave=" + autosave +
                '}';
    }
}
