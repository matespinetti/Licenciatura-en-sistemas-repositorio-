program leer;
type
	archivo = file of integer;

var
	arch_num: archivo;
	nFisico: string;
	num: integer;
	
	
begin
	writeln ('Ingrese el nombre del archivo');
	readln (nFisico);
	assign (arch_num, nFisico);
	Reset (arch_num);
	while (not eof(arch_num)) do 
		begin
			read (arch_num, num);
			writeln (num);
		
		end;

	close (arch_num);
end.

