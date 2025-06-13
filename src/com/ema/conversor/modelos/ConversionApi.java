package com.ema.conversor.modelos;

public record ConversionApi(String base_code, String tarjet_code, Double conversion_rate, Double conversion_result, String time_last_update_utc) {
}
