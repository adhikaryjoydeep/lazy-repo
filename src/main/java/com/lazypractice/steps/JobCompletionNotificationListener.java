package com.lazypractice.steps;

import com.lazypractice.beans.JobResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Component
public class JobCompletionNotificationListener implements JobExecutionListener{
    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

    private final EntityManager em;

    @Autowired
    public JobCompletionNotificationListener(EntityManager em) {
        this.em = em;
    }


    @Override
    @Transactional
  public void afterJob(JobExecution jobExecution) {
    if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
      log.info("!!! JOB FINISHED! Time to verify the results");
      Map<Long, JobResult> jobData = new HashMap<>();

//       em.createQuery("SELECT id,city,date FROM Match m",Object[].class)
//              .getResultList()
//              .stream()
//              .map(e -> new JobResult((Long)e[0],(String)e[1],(LocalDate) e[2]))
//               .forEach(j->jobData.put(j.getId(),j));

        em.createQuery("SELECT id,city,date FROM Match m",Object[].class)
                .getResultList().forEach(e->{
                    jobData.put((Long)e[0],new JobResult((Long)e[0],(String)e[1],(LocalDate) e[2])) ;
                });
        System.out.printf(""+jobData);
    }
  }

    @Override
    public void beforeJob(JobExecution jobExecution) {
        System.out.println("Before Job has been executed.......");
    }
}
