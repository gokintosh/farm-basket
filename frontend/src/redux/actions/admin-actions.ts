import { FORM_RESET, ResetActionType } from "../action-types/admin-action-types";

export const reset = (): ResetActionType => ({
    type: FORM_RESET
});