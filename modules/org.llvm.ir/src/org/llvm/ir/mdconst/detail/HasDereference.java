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

package org.llvm.ir.mdconst.detail;

import org.clank.support.*;

//
// JAVA: I think this class will be never used in Java,
// so I've just made it compile somehow.
//
// In the original c++ code, value static field is true if and only if
// class T is a pointer or has overloaded operator * and
// result of * is convertibel to Result
//

/*template <class T, class Result> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::mdconst::detail::HasDereference">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 467,
 FQN="llvm::mdconst::detail::HasDereference", NM="_ZN4llvm7mdconst6detail14HasDereferenceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm7mdconst6detail14HasDereferenceE")
//</editor-fold>
public class/*struct*/ HasDereference</*class*/ T, /*class*/ Result>  {
  /*typedef char Yes[1]*/
//  public final class Yes extends /*char*/byte [1]{ };
  /*typedef char No[2]*/
//  public final class No extends /*char*/byte [2]{ };
  /*template <size_t N> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::mdconst::detail::HasDereference::SFINAE">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 470,
   FQN="llvm::mdconst::detail::HasDereference::SFINAE", NM="_ZN4llvm7mdconst6detail14HasDereference6SFINAEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm7mdconst6detail14HasDereference6SFINAEE")
  //</editor-fold>
  public static class/*struct*/ SFINAE/*<size_t N>*/  {
    
    @Override public String toString() {
      return ""; // NOI18N
    }
  };
  
  /*template <class U, class V> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::mdconst::detail::HasDereference::hasDereference">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 473,
   FQN="llvm::mdconst::detail::HasDereference::hasDereference", NM="Tpl__ZN4llvm7mdconst6detail14HasDereference14hasDereferenceEPNS2_6SFINAEIXszscT0_decl4makeIT_EEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=Tpl__ZN4llvm7mdconst6detail14HasDereference14hasDereferenceEPNS2_6SFINAEIXszscT0_decl4makeIT_EEEEE")
  //</editor-fold>
  public static </*class*/ U, /*class*/ V> boolean hasDereference() {
    return hasDereference(0);
  }
  public static </*class*/ U, /*class*/ V> boolean hasDereference(SFINAE/*SFINAE<sizeof(static_cast<V>(*make<U>()))>*/ /*P*/ $Prm0/*= 0*/) {
    return false;
  }

  /*template <class U, class V> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::mdconst::detail::HasDereference::hasDereference">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 474,
   FQN="llvm::mdconst::detail::HasDereference::hasDereference", NM="Tpl__ZN4llvm7mdconst6detail14HasDereference14hasDereferenceEz",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=Tpl__ZN4llvm7mdconst6detail14HasDereference14hasDereferenceEz")
  //</editor-fold>
  public static </*class*/ U, /*class*/ V> boolean hasDereference(Object ... $VarArg) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // const Metadata & Val = *M; 
  public static /*const*/boolean value = hasDereference(null, null);
  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
