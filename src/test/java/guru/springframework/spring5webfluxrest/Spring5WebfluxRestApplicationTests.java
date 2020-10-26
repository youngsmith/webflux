package guru.springframework.spring5webfluxrest;

import org.apache.commons.lang3.EnumUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.*;
import reactor.test.StepVerifier;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static java.time.Duration.ofSeconds;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class Spring5WebfluxRestApplicationTests {
//
//	@Test
//	public void contextLoads() {
//		int min = 1, max = 5;
//		Flux<Integer> evenNumbers = Flux
//				.range(min, max)
//				.filter(x -> x % 2 == 0); // i.e. 2, 4
//
//		Flux<Integer> oddNumbers = Flux
//				.range(min, max)
//				.filter(x -> x % 2 > 0);  // ie. 1, 3, 5
//
//		Flux<Integer> fluxOfIntegers = evenNumbers.concatWith(oddNumbers);
//
//		// same StepVerifier as in "3.4. Merge"
//		Duration very = StepVerifier.create(fluxOfIntegers)
//				.expectNext(2)
//				.expectNext(4)
//				.expectNext(1)
//				.expectNext(3)
//				.expectNext(5)
//				.expectComplete()
//				.verify();
//	}
//
//	@Test
//	public void test1() {
//		FluxSink<Integer> i;
//
//		Flux.range(1, 20)
//				.doOnRequest(r -> System.out.println("Publisher / request of " + r))
//				.doOnNext(r -> System.out.println("Publisher / element of " + r))
//				.doOnSubscribe(subscription -> System.out.println("Publisher / subscribe is starting!"))
//				.doOnComplete(() -> System.out.println("Publisher / complete!"))
//				.subscribe(new BaseSubscriber<Integer>() {
//					@Override
//					public void hookOnSubscribe(Subscription subscription) {
//						System.out.println("Subscriber / subscribe is starting!");
//						request(20);
//					}
//
//					@Override
//					public void hookOnNext(Integer integer) {
//						//int cnt = (int) (Math.random() * 10.0);
//						//request(1);
//						System.out.println("Subscriber / element of " + integer);
//						//System.out.println("Cancelling after having received " + integer);
//						//cancel();
//					}
//				});
//
//
//	}
//
//	@Test
//	public void test_index() {
//		Flux<Tuple2<Long, Integer>> a = Flux.just(1,2)
//				.index()
//				.log()
//				.map(e -> {
//					System.out.println("index : " + e.getT1());
//					System.out.println("val : " + e.getT2());
//					return e;
//				});
//
//		a.subscribe(i -> System.out.println(i));
//
//	}
//
//	@Test
//	public void test_Subscriber() {
//		Flux.just(1,2,3,4)
//				.log()
//				.subscribe(new Subscriber<Integer>() {
//					private Subscription s;
//					int onNextAmount;
//
//					@Override
//					public void onSubscribe(Subscription s) {
//						this.s = s;
//						s.request(2);
//					}
//
//					@Override
//					public void onNext(Integer integer) {
//						//elements.add(integer);
//						onNextAmount++;
//						if (onNextAmount % 2 == 0) {
//							s.request(2);
//						}
//					}
//
//					@Override
//					public void onError(Throwable t) {
//
//					}
//
//					@Override
//					public void onComplete() {
//
//					}
//				});
//	}
//
//	@Test
//	public void test_BaseSubscriber() {
//		Flux.just(1,2,3,4)
//				.log()
//				.subscribe(new BaseSubscriber<Integer>() {
//					int onNextAmount;
//
//					@Override
//					public void hookOnSubscribe(Subscription s) {
//						request(2);
//					}
//
//					@Override
//					public void hookOnNext(Integer integer) {
//						onNextAmount++;
//						if (onNextAmount % 2 == 0) {
//							request(2);
//						}
//					}
//				});
//	}
//
//	@Test
//	public void test_ConnectableFlux() {
//		// infinite loop
//		ConnectableFlux<Object> publish = Flux.create(fluxSink -> {
//			while(true) {
//				fluxSink.next(System.currentTimeMillis());
//			}
//		})
//				.sample(ofSeconds(2))
//				.publish();
//
//		publish.subscribe(System.out::println);
//		publish.subscribe(System.out::println);
//
//		publish.connect();
//
//	}
//
//
//	@Test
//	public void test_share() {
//		Flux.just(1,2,3,4)
//				.publish()
//				.share();
//	}
//
//
//
//	public enum Jang {
//		cash("a", Arrays.asList("a","b","c")),
//		card("b", Arrays.asList("d","e"));
//
//		private String title;
//		private List<String> payList;
//
//
//		Jang(String a, List<String> asList) {
//			title = a;
//			payList = asList;
//		}
//
//		public void has() {
//			System.out.println(Jang.values());
//		}
//	}
//
//	@Test
//	public void test_enum() {
//
//	}
}
