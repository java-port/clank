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

package org.llvm.adt;

import org.clank.support.*;
import org.llvm.adt.*;


/// ContextualFoldingSetTrait - Like FoldingSetTrait, but for
/// ContextualFoldingSets.
/*template <typename T, typename Ctx> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::ContextualFoldingSetTrait">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 272,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 258,
 FQN="llvm::ContextualFoldingSetTrait", NM="_ZN4llvm25ContextualFoldingSetTraitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm25ContextualFoldingSetTraitE")
//</editor-fold>
public interface/*struct*/ ContextualFoldingSetTrait</*typename*/ T, /*typename*/ Ctx> {
  //<editor-fold defaultstate="collapsed" desc="llvm::DefaultContextualFoldingSetTrait::Profile">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 261,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 247,
   FQN="llvm::DefaultContextualFoldingSetTrait::Profile", NM="_ZN4llvm32DefaultContextualFoldingSetTrait7ProfileERT_RNS_16FoldingSetNodeIDET0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm32DefaultContextualFoldingSetTrait7ProfileERT_RNS_16FoldingSetNodeIDET0_")
  //</editor-fold>
  public void Profile(final T /*&*/ X, final FoldingSetNodeID /*&*/ ID, Ctx Context);
 
  //<editor-fold defaultstate="collapsed" desc="llvm::DefaultContextualFoldingSetTrait::Equals">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 385,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 371,
   FQN="llvm::DefaultContextualFoldingSetTrait::Equals", NM="_ZN4llvm32DefaultContextualFoldingSetTrait6EqualsERT_RKNS_16FoldingSetNodeIDEjRS3_T0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm32DefaultContextualFoldingSetTrait6EqualsERT_RKNS_16FoldingSetNodeIDEjRS3_T0_")
  //</editor-fold>
  public boolean Equals(final T /*&*/ X, 
        final /*const*/ FoldingSetNodeID /*&*/ ID, 
        /*uint*/int $Prm2/*IDHash*/, 
        final FoldingSetNodeID /*&*/ TempID, 
        Ctx Context);

  //<editor-fold defaultstate="collapsed" desc="llvm::DefaultContextualFoldingSetTrait::ComputeHash">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 395,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 381,
   FQN="llvm::DefaultContextualFoldingSetTrait::ComputeHash", NM="_ZN4llvm32DefaultContextualFoldingSetTrait11ComputeHashERT_RNS_16FoldingSetNodeIDET0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm32DefaultContextualFoldingSetTrait11ComputeHashERT_RNS_16FoldingSetNodeIDET0_")
  //</editor-fold>
  public /*uint*/int ComputeHash(final T /*&*/ X, 
             final FoldingSetNodeID /*&*/ TempID, 
             Ctx Context);
}
