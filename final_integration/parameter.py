CHAR_VECTOR = "adefghjknqrstwABCDEFGHIJKLMNOPZ0123456789X"

letters = [letter for letter in CHAR_VECTOR]

num_classes = len(letters) + 1

img_w, img_h = 128, 64

# Network parameters
batch_size = 128
val_batch_size = 16

downsample_factor = 4
# max_text_len 이 10일경우와 9 일 경우가 있다. -> 고려할 필요가 있음.
new_max_text_len = 10
max_text_len = 10