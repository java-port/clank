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

package org.llvm.ir;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.JD$Move;


/// A CRTP mix-in to automatically provide informational APIs needed for
/// analysis passes.
///
/// This provides some boiler plate for types that are analysis passes. It
/// automatically mixes in \c PassInfoMixin and adds informational APIs
/// specifically used for analyses.
/*template <typename DerivedT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::AnalysisInfoMixin">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 196,
 FQN="llvm::AnalysisInfoMixin", NM="_ZN4llvm17AnalysisInfoMixinE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm17AnalysisInfoMixinE")
//</editor-fold>
public interface/*struct*/ AnalysisInfoMixin</*typename*/ DerivedT>  extends /**/ PassInfoMixin<DerivedT> {
  /// Returns an opaque, unique ID for this pass type.
  ///
  /// Note that this requires the derived type provide a static member whose
  /// address can be converted to a void pointer.
  ///
  /// FIXME: The only reason the derived type needs to provide this rather than
  /// this mixin providing it is due to broken implementations which cannot
  /// correctly unique a templated static so that they have the same addresses
  /// for each instantiation and are definitively emitted once for each
  /// instantiation. The only currently known platform with this limitation are
  /// Windows DLL builds, specifically building each part of LLVM as a DLL. If
  /// we ever remove that build configuration, this mixin can provide the
  /// static PassID as well.
  //<editor-fold defaultstate="collapsed" desc="llvm::AnalysisInfoMixin::ID">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 211,
   FQN="llvm::AnalysisInfoMixin::ID", NM="_ZN4llvm17AnalysisInfoMixin2IDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm17AnalysisInfoMixin2IDEv")
  //</editor-fold>
  public static </*typename*/ DerivedT> Object/*void P*/ ID(Class<DerivedT> clazz) {
    return clazz;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public default void $AnalysisInfoMixin(JD$Move _dparam, AnalysisInfoMixin $Prm0) {}
  
  public default void $AnalysisInfoMixin() {}


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////  
}
