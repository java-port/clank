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

package org.llvm.analysis;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import static org.llvm.ir.PassManagerGlobals.*;

//<editor-fold defaultstate="collapsed" desc="llvm::ilist_traits<IVStrideUse>">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IVUsers.h", line = 93,
 FQN="llvm::ilist_traits<IVStrideUse>", NM="_ZN4llvm12ilist_traitsINS_11IVStrideUseEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZN4llvm12ilist_traitsINS_11IVStrideUseEEE")
//</editor-fold>
public interface/*struct*/ ilist_traitsIVStrideUse extends /*public*/ ilist_default_traits<IVStrideUse> {
  // createSentinel is used to get hold of a node that marks the end of
  // the list...
  // The sentinel is relative to this instance, so we use a non-static
  // method.
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_traits<IVStrideUse>::createSentinel">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IVUsers.h", line = 99,
   FQN="llvm::ilist_traits<IVStrideUse>::createSentinel", NM="_ZNK4llvm12ilist_traitsINS_11IVStrideUseEE14createSentinelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZNK4llvm12ilist_traitsINS_11IVStrideUseEE14createSentinelEv")
  //</editor-fold>
  public default/*interface*/ IVStrideUse /*P*/ createSentinel() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_traits<IVStrideUse>::destroySentinel">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IVUsers.h", line = 110,
   FQN="llvm::ilist_traits<IVStrideUse>::destroySentinel", NM="_ZN4llvm12ilist_traitsINS_11IVStrideUseEE15destroySentinelEPS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZN4llvm12ilist_traitsINS_11IVStrideUseEE15destroySentinelEPS1_")
  //</editor-fold>
  public /*interface*/ default void destroySentinel(IVStrideUse /*P*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_traits<IVStrideUse>::provideInitialHead">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IVUsers.h", line = 112,
   FQN="llvm::ilist_traits<IVStrideUse>::provideInitialHead", NM="_ZNK4llvm12ilist_traitsINS_11IVStrideUseEE18provideInitialHeadEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZNK4llvm12ilist_traitsINS_11IVStrideUseEE18provideInitialHeadEv")
  //</editor-fold>
  public default/*interface*/ IVStrideUse /*P*/ provideInitialHead() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_traits<IVStrideUse>::ensureHead">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IVUsers.h", line = 113,
   FQN="llvm::ilist_traits<IVStrideUse>::ensureHead", NM="_ZNK4llvm12ilist_traitsINS_11IVStrideUseEE10ensureHeadEPS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZNK4llvm12ilist_traitsINS_11IVStrideUseEE10ensureHeadEPS1_")
  //</editor-fold>
  public default/*interface*/ IVStrideUse /*P*/ ensureHead(type$ref<IVStrideUse> /*P*/ $Prm0) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_traits<IVStrideUse>::noteHead">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IVUsers.h", line = 114,
   FQN="llvm::ilist_traits<IVStrideUse>::noteHead", NM="_ZN4llvm12ilist_traitsINS_11IVStrideUseEE8noteHeadEPS1_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZN4llvm12ilist_traitsINS_11IVStrideUseEE8noteHeadEPS1_S3_")
  //</editor-fold>
  public /*interface*/ default void noteHead(IVStrideUse /*P*/ $Prm0, IVStrideUse /*P*/ $Prm1) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  //public/*private*/ /*mutable */ilist_node<IVStrideUse> Sentinel;
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_traits<IVStrideUse>::ilist_traits">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IVUsers.h", line = 93,
   FQN="llvm::ilist_traits<IVStrideUse>::ilist_traits", NM="_ZN4llvm12ilist_traitsINS_11IVStrideUseEEC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZN4llvm12ilist_traitsINS_11IVStrideUseEEC1Ev")
  //</editor-fold>
  public default/*interface*/ /*inline*/ void $ilist_traitsIVStrideUse() {
    // : ilist_default_traits<IVStrideUse>(), Sentinel() 
    $ilist_default_traits();
    throw new UnsupportedOperationException("EmptyBody");
  }

  
//  @Override public String toString() {
//    return "" + "Sentinel=" + Sentinel // NOI18N
//              + super.toString(); // NOI18N
//  }
}
