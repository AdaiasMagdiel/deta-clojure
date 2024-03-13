@echo off

cd mkdocs
mkdocs build

cd ..
if exist docs (
	rd /s/q docs
)
move mkdocs\site .
ren site docs
