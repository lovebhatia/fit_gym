INSERT INTO public.workout
(created_at, id, image_name, show_sequence, workout)
VALUES('2024-04-04 01:32:09.808', 1, 'chest_home.jpg', '1', 'Chest');
INSERT INTO public.workout
(created_at, id, image_name, show_sequence, workout)
VALUES('2024-04-04 01:32:09.808', 2, 'back_home.jpg', '2', 'Back');
INSERT INTO public.workout
(created_at, id, image_name, show_sequence, workout)
VALUES('2024-04-04 01:32:09.808', 3, 'biceps_home.jpg', '3', 'Biceps');
INSERT INTO public.workout
(created_at, id, image_name, show_sequence, workout)
VALUES('2024-04-04 01:32:09.808', 4, 'shoulder_home.jpg', '4', 'Shoulder');
INSERT INTO public.workout
(created_at, id, image_name, show_sequence, workout)
VALUES('2024-04-04 01:32:09.808', 5, 'tricep_home.jpg', '5', 'Tricep');
INSERT INTO public.workout
(created_at, id, image_name, show_sequence, workout)
VALUES('2024-04-04 01:32:09.808', 6, 'abs_home.jpg', '6', 'Abs');


INSERT INTO public.exercise
(created_at, id, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES('2024-04-04 01:52:34.669', 1, NULL, NULL, NULL, 'Bench Press', 'BenchPress.gif', '3-5', NULL);
INSERT INTO public.exercise
(created_at, id, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES('2024-04-04 01:52:34.669', 2, NULL, NULL, NULL, 'Cable Low Fly', 'CableLowFly.gif', '3-5', NULL);
INSERT INTO public.exercise
(created_at, id, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES('2024-04-04 01:52:34.669', 3, NULL, NULL, NULL, 'Cable Standing Fly', 'CableStandingFly.gif', '3-5', NULL);
INSERT INTO public.exercise
(created_at, id, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES('2024-04-04 01:52:34.669', 4, NULL, NULL, NULL, 'Chest Dip', 'ChestDip.gif', '3-5', NULL);
INSERT INTO public.exercise
(created_at, id, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES('2024-04-04 01:52:34.669', 5, NULL, NULL, NULL, 'DumbellBenchPress', 'DumbellBenchPress.gif', '3-5', NULL);
INSERT INTO public.exercise
(created_at, id, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES('2024-04-04 01:52:34.669', 6, NULL, NULL, NULL, 'Fly', 'Fly.gif', '3-5', NULL);
INSERT INTO public.exercise
(created_at, id, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES('2024-04-04 01:52:34.669', 7, NULL, NULL, NULL, 'Incline Bench Press', 'InclineBenchPress.gif', '3-5', NULL);
INSERT INTO public.exercise
(created_at, id, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES('2024-04-04 01:52:34.669', 8, NULL, NULL, NULL, 'Incline Dumbbell Bench Press', 'InclineDumbbellBenchPress.gif', '3-5', NULL);
INSERT INTO public.exercise
(created_at, id, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES('2024-04-04 01:52:34.669', 9, NULL, NULL, NULL, 'Incline Fly', 'InclineFly.gif', '3-5', NULL);
INSERT INTO public.exercise
(created_at, id, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES('2024-04-04 01:52:34.669', 10, NULL, NULL, NULL, 'LeverSeatedFly', 'LeverSeatedFly.gif', '3-5', NULL);
INSERT INTO public.exercise
(created_at, id, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES('2024-04-04 01:52:34.669', 11, NULL, NULL, NULL, 'Pullover', 'Pullover.gif', '3-5', NULL);
INSERT INTO public.exercise
(created_at, id, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES('2024-04-04 01:52:34.669', 12, NULL, NULL, NULL, 'Push-up', 'Push-up.gif', '3-5', NULL);


INSERT INTO public.workout_exercises
(exercise_id, workout_id)
VALUES(1, 1);
INSERT INTO public.workout_exercises
(exercise_id, workout_id)
VALUES(2, 1);
INSERT INTO public.workout_exercises
(exercise_id, workout_id)
VALUES(3, 1);
INSERT INTO public.workout_exercises
(exercise_id, workout_id)
VALUES(4, 1);
INSERT INTO public.workout_exercises
(exercise_id, workout_id)
VALUES(5, 1);
INSERT INTO public.workout_exercises
(exercise_id, workout_id)
VALUES(6, 1);
INSERT INTO public.workout_exercises
(exercise_id, workout_id)
VALUES(7, 1);
INSERT INTO public.workout_exercises
(exercise_id, workout_id)
VALUES(8, 1);
INSERT INTO public.workout_exercises
(exercise_id, workout_id)
VALUES(9, 1);
INSERT INTO public.workout_exercises
(exercise_id, workout_id)
VALUES(10, 1);
INSERT INTO public.workout_exercises
(exercise_id, workout_id)
VALUES(11, 1);
INSERT INTO public.workout_exercises
(exercise_id, workout_id)
VALUES(12, 1);

INSERT INTO public.exercise
(created_at,  claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence, image_name)
VALUES(current_date, NULL, NULL, NULL, 'Tricpes Pushdown', '', '3-5', NULL, NULL); 
INSERT INTO public.exercise
(created_at,  claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence, image_name)
VALUES(current_date, NULL, NULL, NULL, 'Overhead Triceps Extension', '', '3-5', NULL, NULL);
INSERT INTO public.exercise
(created_at,  claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence, image_name)
VALUES(current_date, NULL, NULL, NULL, 'Cable Pushdown', '', '3-5', NULL, NULL);
INSERT INTO public.exercise
(created_at,  claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence, image_name)
VALUES(current_date, NULL, NULL, NULL, 'Dip on Floor with Chair', '', '3-5', NULL, NULL);
INSERT INTO public.exercise
(created_at,  claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence, image_name)
VALUES(current_date, NULL, NULL, NULL, 'High Pulley Overhead Tricep Extension', '', '3-5', NULL, NULL);
INSERT INTO public.exercise
(created_at,  claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence, image_name)
VALUES(current_date, NULL, NULL, NULL, 'Standing Tricep Extension', '', '3-5', NULL, NULL);
INSERT INTO public.exercise
(created_at,  claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence, image_name)
VALUES(current_date, NULL, NULL, NULL, 'Close-grip Push-up', '', '3-5', NULL, NULL);
INSERT INTO public.exercise
(created_at,  claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence, image_name)
VALUES(current_date, NULL, NULL, NULL, 'Tricpes Pushdown', '', '3-5', NULL, NULL);
INSERT INTO public.exercise
(created_at,  claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence, image_name)
VALUES(current_date, NULL, NULL, NULL, 'Seated bench Extension', '', '3-5', NULL, NULL);
INSERT INTO public.exercise
(created_at,  claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence, image_name)
VALUES(current_date, NULL, NULL, NULL, 'Triceps Dip', '', '3-5', NULL, NULL);
INSERT INTO public.exercise
(created_at,  claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence, image_name)
VALUES(current_date, NULL, NULL, NULL, 'Close-Grip Bench Press', '', '3-5', NULL, NULL);
INSERT INTO public.exercise
(created_at,  claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence, image_name)
VALUES(current_date, NULL, NULL, NULL, 'Cable Tricep Pushdown', '', '3-5', NULL, NULL);
INSERT INTO public.exercise
(created_at,  claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence, image_name)
VALUES(current_date, NULL, NULL, NULL, 'Bench Dip', '', '3-5', NULL, NULL);
INSERT INTO public.exercise
(created_at,  claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence, image_name)
VALUES(current_date, NULL, NULL, NULL, 'Lever Seated Dip', '', '3-5', NULL, NULL);
INSERT INTO public.exercise
(created_at,  claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence, image_name)
VALUES(current_date, NULL, NULL, NULL, 'Kickback', '', '3-5', NULL, NULL);

INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(13, 5);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(14, 5);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(15, 5);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(16, 5);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(17, 5);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(18, 5);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(19, 5);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(20, 5);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(21, 5);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(22, 5);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(23, 5);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(24, 5);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(25, 5);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(26, 5);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(27, 5);

INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Bar Lateral Pulldown', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Barbell Bent Over Row', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Bent over Row', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Cable Standing Lat Pushdown', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Lat Pull Down Closed Grip', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Lateral Pull-Down V-Bar', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Lateral Bent Over Row', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Pull-up', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Seated Back Row Straight', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Wide Grip Lat Pull Down', '', '3-5', NULL);

INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(28, 2);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(29, 2);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(30, 2);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(31, 2);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(32, 2);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(33, 2);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(34, 2);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(35, 2);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(36, 2);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(37, 2);


INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Lateral Raise', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Seated Shoulder Press', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Lever Seated Shoulder Press', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Front Raise', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Lever Seated Reverse Fly', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Brabell Standing Military Press', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Arnold Press', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Dumbbell Seated Shoulder Press', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Dumbbell Rear Delt Fly', '', '3-5', NULL);




INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(38, 4);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(39, 4);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(40, 4);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(41, 4);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(42, 4);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(43, 4);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(44, 4);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(45, 4);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(46, 4);





INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Cable Kneeling Crush', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Crunch Floor', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Decline Crunch', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Dumbbell Side Bend', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Hanging Leg Hip Raise', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Hyperextension', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Lying Leg Raise', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Plank', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Russian Twist', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Side Plank', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Straight Leg Raise', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Weighted Russian Twist', '', '3-5', NULL);

INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(47, 6);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(48, 6);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(49, 6);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(50, 6);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(51, 6);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(52, 6);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(53, 6);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(54, 6);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(55, 6);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(56, 6);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(57, 6);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(58, 6);

INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Bulgarian Split Squat', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Bulgarian Split Squats Dumbbell', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Full Squats', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Leg Curl', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Leg Wide Press', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Lever Kneeling Leg Curl', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Lever Leg Extension', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Lunges', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Lunges Walking', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Sled Hack Squats', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Sqauts', '', '3-5', NULL);


INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(59, 7);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(60, 7);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(61, 7);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(62, 7);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(63, 6);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(64, 6);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(65, 6);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(66, 6);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(67, 6);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(68, 6);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(69, 6);



INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Dumbbell Lying Hamstring Curl', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Lever Kneeling Leg Curl', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Lever Lying Leg Curl', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Lever Seated Leg Curl', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Lying Femoral', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Seated Single Leg Hamstring', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Straight Leg Deadlift', '', '3-5', NULL);

INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(70, 8);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(71, 8);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(72, 8);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(73, 8);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(74, 8);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(75, 8);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(76, 8);

INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Deadlift', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Dumbbell Bar Grip Sumo Squat', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Dumbbell Glute Bridge', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Lever Kneeling Leg Curl', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Dumbbell Single Leg Deadlift', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Hip Thrust', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Lever Seated Hip Abduction', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Romanian Deadlift', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Romanian Deadlift Dumbbell', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Sled 45 Degree Leg Press', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Sled Hack Squat', '', '3-5', NULL);
INSERT INTO public.exercise
(created_at, claories_burned, exercise_description, exercise_duration, exercise_name, gif_name, set_range, show_sequence)
VALUES(current_date,  NULL, NULL, NULL, 'Sumo Deadlift', '', '3-5', NULL);

INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(77, 9);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(78, 9);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(79, 9);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(80, 9);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(81, 9);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(82, 9);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(83, 9);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(84, 9);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(85, 9);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(86, 9);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(87, 9);
INSERT INTO public.workout_exercises (exercise_id, workout_id) VALUES(88, 9);











INSERT INTO public.workout
(created_at, image_name, show_sequence, workout)
VALUES('2024-04-04 01:32:09.808', 'hamstring_home.jpg', '8', 'Hamstring');


delete from exercise  where id = 24
delete from workout_exercises where exercise_id = 24

delete from exercise  where id = 17
delete from workout_exercises where exercise_id = 17 

delete from exercise  where id = 34
delete from workout_exercises where exercise_id = 34

delete from exercise  where id = 26
delete from workout_exercises where exercise_id = 26

delete from exercise  where id = 60
delete from workout_exercises where exercise_id = 60