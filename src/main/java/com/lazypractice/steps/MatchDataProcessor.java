package com.lazypractice.steps;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import org.springframework.batch.item.ItemProcessor;

import com.lazypractice.beans.Match;
import com.lazypractice.beans.MatchInput;
import org.springframework.format.annotation.DateTimeFormat;

public class MatchDataProcessor implements ItemProcessor<MatchInput, Match>{

    @Override
    public Match process(final MatchInput matchInput) throws Exception {
        System.out.printf("Procesing "+matchInput);
        Match match = new Match();
        match.setId(matchInput.getId());
        match.setCity(matchInput.getCity());
        match.setDate(LocalDate.parse(LocalDate.parse(matchInput.getDate()).format(DateTimeFormatter.ISO_LOCAL_DATE)));

        return match;
    }

}
