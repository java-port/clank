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
package org.llvm.mc;

import org.clank.support.*;
import org.clank.support.NativeCallback.New$ConstructorCallback;
import org.clank.support.aliases.type$ptr;


//<editor-fold defaultstate="collapsed" desc="static type MCContextGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.mc.MCContextGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZdaPvRN4llvm9MCContextE;_ZdlPvRN4llvm9MCContextEj;_ZnajRN4llvm9MCContextEj;_ZnwjRN4llvm9MCContextEj; -static-type=MCContextGlobals -package=org.llvm.mc")
//</editor-fold>
public final class MCContextGlobals {

// end namespace llvm

// operator new and delete aren't allowed inside namespaces.
// The throw specifications are mandated by the standard.
/// \brief Placement new for using the MCContext's allocator.
///
/// This placement form of operator new uses the MCContext's allocator for
/// obtaining memory. It is a non-throwing new, which means that it returns
/// null on error. (If that is what the allocator does. The current does, so if
/// this ever changes, this operator will have to be changed, too.)
/// Usage looks like this (assuming there's an MCContext 'Context' in scope):
/// \code
/// // Default alignment (8)
/// IntegerLiteral *Ex = new (Context) IntegerLiteral(arguments);
/// // Specific alignment
/// IntegerLiteral *Ex2 = new (Context, 4) IntegerLiteral(arguments);
/// \endcode
/// Please note that you cannot use delete on the pointer; it must be
/// deallocated using an explicit destructor call followed by
/// \c Context.Deallocate(Ptr).
///
/// \param Bytes The number of bytes to allocate. Calculated by the compiler.
/// \param C The MCContext that provides the allocator.
/// \param Alignment The alignment of the allocated memory (if the underlying
///                  allocator supports it).
/// \return The allocated memory. Could be NULL.
//<editor-fold defaultstate="collapsed" desc="operator new">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 614,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 556,
 FQN="operator new", NM="_ZnwjRN4llvm9MCContextEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZnwjRN4llvm9MCContextEj")
//</editor-fold>
public static /*inline*/ Object/*void P*/ $new_uint_MCContext_uint(/*size_t*/int Bytes, final MCContext /*&*/ C) {
  return $new_uint_MCContext_uint(Bytes, C, 
                        8);
}
public static /*inline*/ Object/*void P*/ $new_uint_MCContext_uint(/*size_t*/int Bytes, final MCContext /*&*/ C, 
                        /*size_t*/int Alignment/*= 8*/) {
  return C.allocate(Bytes, Alignment);
}

/// \brief Placement delete companion to the new above.
///
/// This operator is just a companion to the new above. There is no way of
/// invoking it directly; see the new operator for more details. This operator
/// is called implicitly by the compiler if a placement new expression using
/// the MCContext throws in the object constructor.
//<editor-fold defaultstate="collapsed" desc="operator delete">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 624,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 566,
 FQN="operator delete", NM="_ZdlPvRN4llvm9MCContextEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZdlPvRN4llvm9MCContextEj")
//</editor-fold>
public static /*inline*/ void $delete_voidPtr_MCContext_uint(Object/*void P*/ Ptr, final MCContext /*&*/ C, 
                              /*size_t*/int $Prm2) {
  C.deallocate(Ptr);
}


/// This placement form of operator new[] uses the MCContext's allocator for
/// obtaining memory. It is a non-throwing new[], which means that it returns
/// null on error.
/// Usage looks like this (assuming there's an MCContext 'Context' in scope):
/// \code
/// // Default alignment (8)
/// char *data = new (Context) char[10];
/// // Specific alignment
/// char *data = new (Context, 4) char[10];
/// \endcode
/// Please note that you cannot use delete on the pointer; it must be
/// deallocated using an explicit destructor call followed by
/// \c Context.Deallocate(Ptr).
///
/// \param Bytes The number of bytes to allocate. Calculated by the compiler.
/// \param C The MCContext that provides the allocator.
/// \param Alignment The alignment of the allocated memory (if the underlying
///                  allocator supports it).
/// \return The allocated memory. Could be NULL.
//<editor-fold defaultstate="collapsed" desc="operator new[]">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 648,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 590,
 FQN="operator new[]", NM="_ZnajRN4llvm9MCContextEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZnajRN4llvm9MCContextEj")
//</editor-fold>
public static /*inline*/ Object/*void P*/ $array_new_uint_MCContext_uint(/*size_t*/int Bytes, final MCContext /*&*/ C) {
  return $array_new_uint_MCContext_uint(Bytes, C, 
                              8);
}
public static /*inline*/ Object/*void P*/ $array_new_uint_MCContext_uint(/*size_t*/int Bytes, final MCContext /*&*/ C, 
                              /*size_t*/int Alignment/*= 8*/) {
  return C.allocate(Bytes, Alignment);
}


/// \brief Placement delete[] companion to the new[] above.
///
/// This operator is just a companion to the new[] above. There is no way of
/// invoking it directly; see the new[] operator for more details. This operator
/// is called implicitly by the compiler if a placement new[] expression using
/// the MCContext throws in the object constructor.
//<editor-fold defaultstate="collapsed" desc="operator delete[]">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 659,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 601,
 FQN="operator delete[]", NM="_ZdaPvRN4llvm9MCContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZdaPvRN4llvm9MCContextE")
//</editor-fold>
public static /*inline*/ void $array_delete_voidPtr_MCContext(Object/*void P*/ Ptr, final MCContext /*&*/ C) {
  C.deallocate(Ptr);
}

public static <T> T/*P*/ $new_uint_MCContext_uint(final MCContext /*&*/ C, New$ConstructorCallback<T/*P*/> New$Ctr) {
  return $new_uint_MCContext_uint(C, New$Ctr, 8);
}
public static <T> T/*P*/ $new_uint_MCContext_uint(final MCContext /*&*/ C, New$ConstructorCallback<T/*P*/> New$Ctr, /*uint*/int Alignment) {
  return New$Ctr.$call((type$ptr<?>)null);
}

} // END OF class MCContextGlobals
