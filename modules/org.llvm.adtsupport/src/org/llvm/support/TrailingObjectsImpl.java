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

package org.llvm.support;

import org.clank.support.*;

/// See the file comment for details on the usage of the
/// TrailingObjects type.
//<editor-fold defaultstate="collapsed" desc="llvm::trailing_objects_internal::TrailingObjectsImpl<Align, type-parameter-0-1, type-parameter-0-2, type-parameter-0-3, type-parameter-0-4, type-parameter-0-5...>">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/TrailingObjects.h", line = 135,
 FQN="llvm::trailing_objects_internal::TrailingObjectsImpl<Align, type-parameter-0-1, type-parameter-0-2, type-parameter-0-3, type-parameter-0-4, type-parameter-0-5...>", NM="_ZN4llvm25trailing_objects_internal19TrailingObjectsImplIXT_ET0_T1_T2_JT3_DpT4_EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN4llvm25trailing_objects_internal19TrailingObjectsImplIXT_ET0_T1_T2_JT3_DpT4_EEE")
//</editor-fold>
public interface TrailingObjectsImpl</*typename*/ BaseTy, /*typename*/ /*...*/ TrailingTys> {

  // This is a dummy method, only here so the "using" doesn't fail --
  // it will never be called, because this function recurses backwards
  // up the inheritance chain to subclasses.
  //<editor-fold defaultstate="collapsed" desc="llvm::trailing_objects_internal::TrailingObjectsImpl<Align, type-parameter-0-1, type-parameter-0-2, type-parameter-0-3, >::getTrailingObjectsImpl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/TrailingObjects.h", line = 215,
   FQN="llvm::trailing_objects_internal::TrailingObjectsImpl<Align, type-parameter-0-1, type-parameter-0-2, type-parameter-0-3, >::getTrailingObjectsImpl", NM="_ZN4llvm25trailing_objects_internal19TrailingObjectsImplIXT_ET0_T1_T2_JEE22getTrailingObjectsImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN4llvm25trailing_objects_internal19TrailingObjectsImplIXT_ET0_T1_T2_JEE22getTrailingObjectsImplEv")
  //</editor-fold>
  public default void getTrailingObjectsImpl() {
    throw new UnsupportedOperationException("EmptyBody");
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::trailing_objects_internal::TrailingObjectsImpl<Align, type-parameter-0-1, type-parameter-0-2, type-parameter-0-3, >::additionalSizeToAllocImpl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/TrailingObjects.h", line = 217,
   FQN="llvm::trailing_objects_internal::TrailingObjectsImpl<Align, type-parameter-0-1, type-parameter-0-2, type-parameter-0-3, >::additionalSizeToAllocImpl", NM="_ZN4llvm25trailing_objects_internal19TrailingObjectsImplIXT_ET0_T1_T2_JEE25additionalSizeToAllocImplEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN4llvm25trailing_objects_internal19TrailingObjectsImplIXT_ET0_T1_T2_JEE25additionalSizeToAllocImplEj")
  //</editor-fold>
  public default /*size_t*/int additionalSizeToAllocImpl(/*size_t*/int SizeSoFar) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /*template <bool CheckAlignment> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::trailing_objects_internal::TrailingObjectsImpl<Align, type-parameter-0-1, type-parameter-0-2, type-parameter-0-3, >::verifyTrailingObjectsAlignment">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/TrailingObjects.h", line = 221,
   FQN="llvm::trailing_objects_internal::TrailingObjectsImpl<Align, type-parameter-0-1, type-parameter-0-2, type-parameter-0-3, >::verifyTrailingObjectsAlignment", NM="Tpl__ZN4llvm25trailing_objects_internal19TrailingObjectsImplIXT_ET0_T1_T2_JEE30verifyTrailingObjectsAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=Tpl__ZN4llvm25trailing_objects_internal19TrailingObjectsImplIXT_ET0_T1_T2_JEE30verifyTrailingObjectsAlignmentEv")
  //</editor-fold>
  public default void verifyTrailingObjectsAlignment(boolean CheckAlignment) {
    throw new UnsupportedOperationException("EmptyBody");
  }
}
