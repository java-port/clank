/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */
package org.clang.ast;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.NativeCallback.*;
import static org.clang.ast.ASTContextGlobals.*;


//<editor-fold defaultstate="collapsed" desc="static type ASTContextGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZdaPvRKN5clang10ASTContextEj;_ZdlPvRKN5clang10ASTContextEj;_ZnajRKN5clang10ASTContextEj;_ZnwjRKN5clang10ASTContextEj; -static-type=ASTContextGlobals -package=org.clang.ast")
//</editor-fold>
public final class ASTContextGlobals {


// Defined in ASTContext.h
// end namespace clang

// operator new and delete aren't allowed inside namespaces.

/// @brief Placement new for using the ASTContext's allocator.
///
/// This placement form of operator new uses the ASTContext's allocator for
/// obtaining memory.
///
/// IMPORTANT: These are also declared in clang/AST/AttrIterator.h! Any changes
/// here need to also be made there.
///
/// We intentionally avoid using a nothrow specification here so that the calls
/// to this operator will not perform a null check on the result -- the
/// underlying allocator never returns null pointers.
///
/// Usage looks like this (assuming there's an ASTContext 'Context' in scope):
/// @code
/// // Default alignment (8)
/// IntegerLiteral *Ex = new (Context) IntegerLiteral(arguments);
/// // Specific alignment
/// IntegerLiteral *Ex2 = new (Context, 4) IntegerLiteral(arguments);
/// @endcode
/// Memory allocated through this placement new operator does not need to be
/// explicitly freed, as ASTContext will free all of this memory when it gets
/// destroyed. Please note that you cannot use delete on the pointer.
///
/// @param Bytes The number of bytes to allocate. Calculated by the compiler.
/// @param C The ASTContext that provides the allocator.
/// @param Alignment The alignment of the allocated memory (if the underlying
///                  allocator supports it).
/// @return The allocated memory. Could be NULL.
//<editor-fold defaultstate="collapsed" desc="operator new">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 2648,
 FQN="operator new", NM="_ZnwjRKN5clang10ASTContextEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZnwjRKN5clang10ASTContextEj")
//</editor-fold>
public static /*inline*/ Object/*void P*/ $new_uint_ASTContext$C_uint(/*size_t*/int Bytes, final /*const*/ ASTContext /*&*/ C) {
  return $new_uint_ASTContext$C_uint(Bytes, C, 
                           8);
}
public static /*inline*/ Object/*void P*/ $new_uint_ASTContext$C_uint(/*size_t*/int Bytes, final /*const*/ ASTContext /*&*/ C, 
                           /*size_t*/int Alignment/*= 8*/) {
  return C.Allocate(Bytes, Alignment);
}
public static <T> /*inline*/ T/*void P*/ $new_uint_ASTContext$C_uint(final /*const*/ ASTContext /*&*/ C, New$ConstructorCallback<T/*P*/> New$Ctr) {
  return $new_uint_ASTContext$C_uint(C, /*JAVA*/1, New$Ctr);
}
public static <T> /*inline*/ T/*void P*/ $new_uint_ASTContext$C_uint(final /*const*/ ASTContext /*&*/ C,
                           /*size_t*/int Alignment/*= 1*/, New$ConstructorCallback<T/*P*/> New$Ctr) {
  assert Alignment == 1 : "For Java reference alignment is 1";
  type$ptr<?> MemoryLocation = C.Allocate$JavaRef(1);
  T createdObject = New$Ctr.$call(MemoryLocation);
  return createdObject;
}

// FIXME: Being forced to not have a default argument here due to redeclaration
//        rules on default arguments sucks

/// This placement form of operator new[] uses the ASTContext's allocator for
/// obtaining memory.
///
/// We intentionally avoid using a nothrow specification here so that the calls
/// to this operator will not perform a null check on the result -- the
/// underlying allocator never returns null pointers.
///
/// Usage looks like this (assuming there's an ASTContext 'Context' in scope):
/// @code
/// // Default alignment (8)
/// char *data = new (Context) char[10];
/// // Specific alignment
/// char *data = new (Context, 4) char[10];
/// @endcode
/// Memory allocated through this placement new[] operator does not need to be
/// explicitly freed, as ASTContext will free all of this memory when it gets
/// destroyed. Please note that you cannot use delete on the pointer.
///
/// @param Bytes The number of bytes to allocate. Calculated by the compiler.
/// @param C The ASTContext that provides the allocator.
/// @param Alignment The alignment of the allocated memory (if the underlying
///                  allocator supports it).
/// @return The allocated memory. Could be NULL.
//<editor-fold defaultstate="collapsed" desc="operator new[]">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 2685,
 FQN="operator new[]", NM="_ZnajRKN5clang10ASTContextEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZnajRKN5clang10ASTContextEj")
//</editor-fold>
public static /*inline*/ Object/*void P*/ $array_new_uint_ASTContext$C_uint(/*size_t*/int Bytes, final /*const*/ ASTContext /*&*/ C) {
  return $array_new_uint_ASTContext$C_uint(Bytes, C, 
                                 8);
}
public static /*inline*/ Object/*void P*/ $array_new_uint_ASTContext$C_uint(/*size_t*/int Bytes, final /*const*/ ASTContext /*&*/ C, 
                                 /*size_t*/int Alignment/*= 8*/) {
  return C.Allocate(Bytes, Alignment);
}


// It is good practice to pair new/delete operators.  Also, MSVC gives many
// warnings if a matching delete overload is not declared, even though the
// throw() spec guarantees it will not be implicitly called.
/// @brief Placement delete companion to the new above.
///
/// This operator is just a companion to the new above. There is no way of
/// invoking it directly; see the new operator for more details. This operator
/// is called implicitly by the compiler if a placement new expression using
/// the ASTContext throws in the object constructor.
//<editor-fold defaultstate="collapsed" desc="operator delete">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 2658,
 FQN="operator delete", NM="_ZdlPvRKN5clang10ASTContextEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZdlPvRKN5clang10ASTContextEj")
//</editor-fold>
public static /*inline*/ void $delete_voidPtr_ASTContext$C_uint(Object/*void P*/ Ptr, final /*const*/ ASTContext /*&*/ C, /*size_t*/int $Prm2) {
  C.Deallocate(Ptr);
}


/// @brief Placement delete[] companion to the new[] above.
///
/// This operator is just a companion to the new[] above. There is no way of
/// invoking it directly; see the new[] operator for more details. This operator
/// is called implicitly by the compiler if a placement new[] expression using
/// the ASTContext throws in the object constructor.
//<editor-fold defaultstate="collapsed" desc="operator delete[]">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 2696,
 FQN="operator delete[]", NM="_ZdaPvRKN5clang10ASTContextEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZdaPvRKN5clang10ASTContextEj")
//</editor-fold>
public static /*inline*/ void $array_delete_voidPtr_ASTContext$C_uint(Object/*void P*/ Ptr, final /*const*/ ASTContext /*&*/ C, /*size_t*/int $Prm2) {
  C.Deallocate(Ptr);
}

} // END OF class ASTContextGlobals
