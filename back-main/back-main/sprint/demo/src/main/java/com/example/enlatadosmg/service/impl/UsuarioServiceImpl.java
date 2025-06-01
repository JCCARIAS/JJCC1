package com.example.enlatadosmg.service.impl;





import com.enlatadosmg.model.Usuario;
import com.enlatadosmg.repository.UsuarioRepository;
import com.enlatadosmg.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario getUsuarioById(String id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario updateUsuario(String id, Usuario usuario) {
        usuario.setId(id);
        return usuarioRepository.save(usuario);
    }

    @Override
    public void deleteUsuario(String id) {
        usuarioRepository.deleteById(id);
    }
}