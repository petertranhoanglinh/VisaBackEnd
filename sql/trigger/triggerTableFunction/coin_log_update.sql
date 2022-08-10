-- Trigger: coin_update

-- DROP TRIGGER IF EXISTS coin_update ON public.coin;

CREATE TRIGGER coin_update
    AFTER UPDATE 
    ON public.coin
    FOR EACH ROW
    EXECUTE FUNCTION public.coin_log_update();