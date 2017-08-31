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

package org.clang.tooling.core;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;
import org.clang.tooling.core.*;


/// \brief A source range independent of the \c SourceManager.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::Range">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/Core/Replacement.h", line = 38,
 FQN="clang::tooling::Range", NM="_ZN5clang7tooling5RangeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZN5clang7tooling5RangeE")
//</editor-fold>
public class Range implements Native.NativePOD<Range>, Native.NativeComparable<Range> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::Range::Range">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/Core/Replacement.h", line = 40,
   FQN="clang::tooling::Range::Range", NM="_ZN5clang7tooling5RangeC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZN5clang7tooling5RangeC1Ev")
  //</editor-fold>
  public Range() {
    // : Offset(0), Length(0) 
    //START JInit
    this.Offset = 0;
    this.Length = 0;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::tooling::Range::Range">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/Core/Replacement.h", line = 41,
   FQN="clang::tooling::Range::Range", NM="_ZN5clang7tooling5RangeC1Ejj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZN5clang7tooling5RangeC1Ejj")
  //</editor-fold>
  public Range(/*uint*/int Offset, /*uint*/int Length) {
    // : Offset(Offset), Length(Length) 
    //START JInit
    this.Offset = Offset;
    this.Length = Length;
    //END JInit
  }

  
  /// \brief Accessors.
  /// @{
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::Range::getOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/Core/Replacement.h", line = 45,
   FQN="clang::tooling::Range::getOffset", NM="_ZNK5clang7tooling5Range9getOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZNK5clang7tooling5Range9getOffsetEv")
  //</editor-fold>
  public /*uint*/int getOffset() /*const*/ {
    return Offset;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::tooling::Range::getLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/Core/Replacement.h", line = 46,
   FQN="clang::tooling::Range::getLength", NM="_ZNK5clang7tooling5Range9getLengthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZNK5clang7tooling5Range9getLengthEv")
  //</editor-fold>
  public /*uint*/int getLength() /*const*/ {
    return Length;
  }

  /// @}
  
  /// \name Range Predicates
  /// @{
  /// \brief Whether this range overlaps with \p RHS or not.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::Range::overlapsWith">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/Core/Replacement.h", line = 52,
   FQN="clang::tooling::Range::overlapsWith", NM="_ZNK5clang7tooling5Range12overlapsWithES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZNK5clang7tooling5Range12overlapsWithES1_")
  //</editor-fold>
  public boolean overlapsWith(Range RHS) /*const*/ {
    return $greater_uint(Offset + Length, RHS.Offset) && $less_uint(Offset, RHS.Offset + RHS.Length);
  }

  
  /// \brief Whether this range contains \p RHS or not.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::Range::contains">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/Core/Replacement.h", line = 57,
   FQN="clang::tooling::Range::contains", NM="_ZNK5clang7tooling5Range8containsES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZNK5clang7tooling5Range8containsES1_")
  //</editor-fold>
  public boolean contains(Range RHS) /*const*/ {
    return $greatereq_uint(RHS.Offset, Offset)
       && $lesseq_uint((RHS.Offset + RHS.Length), (Offset + Length));
  }

  
  /// \brief Whether this range equals to \p RHS or not.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::Range::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/Core/Replacement.h", line = 63,
   FQN="clang::tooling::Range::operator==", NM="_ZNK5clang7tooling5RangeeqERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZNK5clang7tooling5RangeeqERKS1_")
  //</editor-fold>
  public boolean $eq(final /*const*/ Range /*&*/ RHS) /*const*/ {
    return Offset == RHS.getOffset() && Length == RHS.getLength();
  }

/// @}
  /*private:*/
  private /*uint*/int Offset;
  private /*uint*/int Length;
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::Range::Range">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/Core/Replacement.h", line = 38,
   FQN="clang::tooling::Range::Range", NM="_ZN5clang7tooling5RangeC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZN5clang7tooling5RangeC1ERKS1_")
  //</editor-fold>
  public /*inline*/ Range(final /*const*/ Range /*&*/ $Prm0) {
    // : Offset(.Offset), Length(.Length) 
    //START JInit
    this.Offset = $Prm0.Offset;
    this.Length = $Prm0.Length;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::tooling::Range::Range">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/Core/Replacement.h", line = 38,
   FQN="clang::tooling::Range::Range", NM="_ZN5clang7tooling5RangeC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZN5clang7tooling5RangeC1EOS1_")
  //</editor-fold>
  public /*inline*/ Range(JD$Move _dparam, final Range /*&&*/$Prm0) {
    // : Offset(static_cast<Range &&>().Offset), Length(static_cast<Range &&>().Length) 
    //START JInit
    this.Offset = $Prm0.Offset;
    this.Length = $Prm0.Length;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::tooling::Range::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/Core/Replacement.h", line = 38,
   FQN="clang::tooling::Range::operator=", NM="_ZN5clang7tooling5RangeaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZN5clang7tooling5RangeaSERKS1_")
  //</editor-fold>
  public /*inline*/ Range /*&*/ $assign(final /*const*/ Range /*&*/ $Prm0) {
    this.Offset = $Prm0.Offset;
    this.Length = $Prm0.Length;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::tooling::Range::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/Core/Replacement.h", line = 38,
   FQN="clang::tooling::Range::operator=", NM="_ZN5clang7tooling5RangeaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZN5clang7tooling5RangeaSEOS1_")
  //</editor-fold>
  public /*inline*/ Range /*&*/ $assignMove(final Range /*&&*/$Prm0) {
    this.Offset = $Prm0.Offset;
    this.Length = $Prm0.Length;
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public Range clone() {
    return new Range(this);
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Offset=" + Offset // NOI18N
              + ", Length=" + Length; // NOI18N
  }
}
