package software.amazon.lambda.powertools.metrics.handlers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import software.amazon.cloudwatchlogs.emf.logger.MetricsLogger;
import software.amazon.cloudwatchlogs.emf.model.Unit;
import software.amazon.lambda.powertools.metrics.PowertoolsMetrics;

import static software.amazon.lambda.powertools.metrics.PowertoolsMetricsLogger.metricsLogger;

public class PowertoolsMetricsColdStartEnabledHandler implements RequestHandler<Object, Object> {

    @Override
    @PowertoolsMetrics(namespace = "ExampleApplication", service = "booking", captureColdStart = true)
    public Object handleRequest(Object input, Context context) {
        MetricsLogger metricsLogger = metricsLogger();
        metricsLogger.putMetric("Metric1", 1, Unit.BYTES);

        return null;
    }
}
