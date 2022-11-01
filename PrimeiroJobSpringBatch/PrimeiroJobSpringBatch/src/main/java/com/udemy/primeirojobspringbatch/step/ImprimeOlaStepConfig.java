package com.udemy.primeirojobspringbatch.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImprimeOlaStepConfig {
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step imprimeOlaStep() {
		return stepBuilderFactory.get("imprimeOlaStep").tasklet(imprimirTasket()).build();
	}

	private Tasklet imprimirTasket() {
		return new Tasklet() {
			@Override
			public RepeatStatus execute(
					StepContribution contribution, 
					ChunkContext chunkContext
			) throws Exception {
				System.out.println(String.format("Olá, mundo!"));
				return RepeatStatus.FINISHED;
			}
		};
	}

}
