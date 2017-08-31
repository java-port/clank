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
import static org.clank.support.Unsigned.*;

//<editor-fold defaultstate="collapsed" desc="llvm::MCAlignFragment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 277,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 274,
 FQN="llvm::MCAlignFragment", NM="_ZN4llvm15MCAlignFragmentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm15MCAlignFragmentE")
//</editor-fold>
public class MCAlignFragment extends /*public*/ MCFragment implements Destructors.ClassWithDestructor {
  
  /// Alignment - The alignment to ensure, in bytes.
  private /*uint*/int Alignment;
  
  /// EmitNops - Flag to indicate that (optimal) NOPs should be emitted instead
  /// of using the provided value. The exact interpretation of this flag is
  /// target dependent.
  private /*JBIT bool*/ boolean EmitNops /*: 1*/;
  
  /// Value - Value to use for filling padding bytes.
  private long/*int64_t*/ Value;
  
  /// ValueSize - The size of the integer (in bytes) of \p Value.
  private /*uint*/int ValueSize;
  
  /// MaxBytesToEmit - The maximum number of bytes to emit; if the alignment
  /// cannot be satisfied in this width then this fragment is ignored.
  private /*uint*/int MaxBytesToEmit;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAlignFragment::MCAlignFragment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 298,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 295,
   FQN="llvm::MCAlignFragment::MCAlignFragment", NM="_ZN4llvm15MCAlignFragmentC1EjxjjPNS_9MCSectionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm15MCAlignFragmentC1EjxjjPNS_9MCSectionE")
  //</editor-fold>
  public MCAlignFragment(/*uint*/int Alignment, long/*int64_t*/ Value, /*uint*/int ValueSize, 
      /*uint*/int MaxBytesToEmit) {
    this(Alignment, Value, ValueSize, 
      MaxBytesToEmit, (MCSection /*P*/ )null);
  }
  public MCAlignFragment(/*uint*/int Alignment, long/*int64_t*/ Value, /*uint*/int ValueSize, 
      /*uint*/int MaxBytesToEmit, MCSection /*P*/ Sec/*= null*/) {
    // : MCFragment(FT_Align, false, 0, Sec), Alignment(Alignment), EmitNops(false), Value(Value), ValueSize(ValueSize), MaxBytesToEmit(MaxBytesToEmit) 
    //START JInit
    super(FragmentType.FT_Align, false, $int2uchar(0), Sec);
    this.Alignment = Alignment;
    this.EmitNops = false;
    this.Value = Value;
    this.ValueSize = ValueSize;
    this.MaxBytesToEmit = MaxBytesToEmit;
    //END JInit
  }

  
  /// \name Accessors
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAlignFragment::getAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 307,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 304,
   FQN="llvm::MCAlignFragment::getAlignment", NM="_ZNK4llvm15MCAlignFragment12getAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZNK4llvm15MCAlignFragment12getAlignmentEv")
  //</editor-fold>
  public /*uint*/int getAlignment() /*const*/ {
    return Alignment;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAlignFragment::getValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 309,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 306,
   FQN="llvm::MCAlignFragment::getValue", NM="_ZNK4llvm15MCAlignFragment8getValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZNK4llvm15MCAlignFragment8getValueEv")
  //</editor-fold>
  public long/*int64_t*/ getValue() /*const*/ {
    return Value;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAlignFragment::getValueSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 311,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 308,
   FQN="llvm::MCAlignFragment::getValueSize", NM="_ZNK4llvm15MCAlignFragment12getValueSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZNK4llvm15MCAlignFragment12getValueSizeEv")
  //</editor-fold>
  public /*uint*/int getValueSize() /*const*/ {
    return ValueSize;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAlignFragment::getMaxBytesToEmit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 313,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 310,
   FQN="llvm::MCAlignFragment::getMaxBytesToEmit", NM="_ZNK4llvm15MCAlignFragment17getMaxBytesToEmitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZNK4llvm15MCAlignFragment17getMaxBytesToEmitEv")
  //</editor-fold>
  public /*uint*/int getMaxBytesToEmit() /*const*/ {
    return MaxBytesToEmit;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAlignFragment::hasEmitNops">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 315,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 312,
   FQN="llvm::MCAlignFragment::hasEmitNops", NM="_ZNK4llvm15MCAlignFragment11hasEmitNopsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZNK4llvm15MCAlignFragment11hasEmitNopsEv")
  //</editor-fold>
  public boolean hasEmitNops() /*const*/ {
    return EmitNops;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAlignFragment::setEmitNops">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 316,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 313,
   FQN="llvm::MCAlignFragment::setEmitNops", NM="_ZN4llvm15MCAlignFragment11setEmitNopsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm15MCAlignFragment11setEmitNopsEb")
  //</editor-fold>
  public void setEmitNops(boolean Value) {
    EmitNops = Value;
  }

  
  /// @}
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAlignFragment::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 320,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 317,
   FQN="llvm::MCAlignFragment::classof", NM="_ZN4llvm15MCAlignFragment7classofEPKNS_10MCFragmentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm15MCAlignFragment7classofEPKNS_10MCFragmentE")
  //</editor-fold>
  public static boolean classof(/*const*/ MCFragment /*P*/ F) {
    return F.getKind() == MCFragment.FragmentType.FT_Align;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAlignFragment::~MCAlignFragment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 277,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 274,
   FQN="llvm::MCAlignFragment::~MCAlignFragment", NM="_ZN4llvm15MCAlignFragmentD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm15MCAlignFragmentD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "Alignment=" + Alignment // NOI18N
              + ", EmitNops=" + EmitNops // NOI18N
              + ", Value=" + Value // NOI18N
              + ", ValueSize=" + ValueSize // NOI18N
              + ", MaxBytesToEmit=" + MaxBytesToEmit // NOI18N
              + super.toString(); // NOI18N
  }
}
