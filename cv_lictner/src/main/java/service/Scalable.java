package service;

import javafx.geometry.Rectangle2D;

import java.math.BigDecimal;

/**
 * Created by Solyk on 07.05.2017.
 */
public interface Scalable {
    double HEIGHT_APPLICATION_BUILD = 768;
    double WIDTH_APPLICATION_BUILD = 1366;

    default double getScaleDelta(Rectangle2D bounds){
        double heightDelta = bounds.getHeight()/ HEIGHT_APPLICATION_BUILD;
        double widthDelta = bounds.getWidth()/ WIDTH_APPLICATION_BUILD;
        double result = heightDelta <= widthDelta ? heightDelta : widthDelta;
        return BigDecimal.valueOf(result ).setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
    }

    default double getLayoutXCVWindowDelta(double scaleDelta){
        if (scaleDelta > 1) {
            double remainder = BigDecimal.valueOf((scaleDelta % 1) * 100).setScale(0, BigDecimal.ROUND_HALF_DOWN).doubleValue();
            return BigDecimal.valueOf(remainder * 2.68).setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
        } else {
            double remainder = BigDecimal.valueOf((scaleDelta % 1) * 100).setScale(0, BigDecimal.ROUND_HALF_DOWN).doubleValue();
            double minus = remainder - 100;
            return BigDecimal.valueOf(minus * 2.68).setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
        }
    }

    default double getLayoutYCVWindowDelta(double scaleDelta){
        if (scaleDelta > 1) {
            double remainder = BigDecimal.valueOf((scaleDelta % 1) * 100).setScale(0, BigDecimal.ROUND_HALF_DOWN).doubleValue();
            return BigDecimal.valueOf(remainder * 3.61).setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
        } else {
            double remainder = BigDecimal.valueOf((scaleDelta % 1) * 100).setScale(0, BigDecimal.ROUND_HALF_DOWN).doubleValue();
            double minus = remainder - 100;
            return BigDecimal.valueOf(minus * 3.61).setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
        }
    }

    default double getLayoutXMOJWCWindowDelta(double scaleDelta){
        if (scaleDelta > 1) {
            double remainder = BigDecimal.valueOf((scaleDelta % 1) * 100).setScale(0, BigDecimal.ROUND_HALF_DOWN).doubleValue();
            return BigDecimal.valueOf(remainder * 2.08).setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
        } else {
            double remainder = BigDecimal.valueOf((scaleDelta % 1) * 100).setScale(0, BigDecimal.ROUND_HALF_DOWN).doubleValue();
            double minus = remainder - 100;
            return BigDecimal.valueOf(minus * 2.08).setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
        }
    }

    default double getLayoutYMOJWCWindowDelta(double scaleDelta){
        if (scaleDelta > 1) {
            double remainder = BigDecimal.valueOf((scaleDelta % 1) * 100).setScale(0, BigDecimal.ROUND_HALF_DOWN).doubleValue();
            return BigDecimal.valueOf(remainder * 1.81).setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
        } else {
            double remainder = BigDecimal.valueOf((scaleDelta % 1) * 100).setScale(0, BigDecimal.ROUND_HALF_DOWN).doubleValue();
            double minus = remainder - 100;
            return BigDecimal.valueOf(minus * 1.81).setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
        }
    }
}
