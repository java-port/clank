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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Casts.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import static org.llvm.adt.java.ADTRTTI.*;
import static org.llvm.mc.impl.MCFragmentLlvmStatics.$out_raw_ostream_MCFixup$C;
import static org.llvm.support.AdtsupportLlvmGlobals.$out_raw_ostream_MCExpr$C;
import static org.llvm.support.AdtsupportLlvmGlobals.$out_raw_ostream_MCSymbol$C;

//<editor-fold defaultstate="collapsed" desc="llvm::MCFragment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 25,
 FQN="llvm::MCFragment", NM="_ZN4llvm10MCFragmentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm10MCFragmentE")
//</editor-fold>
public class MCFragment implements /*public*/ ilist_node_with_parent<MCFragment, MCSection>, Destructors.ClassWithDestructor {
  /*friend  class MCAsmLayout*/
  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCFragment::MCFragment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 28,
   FQN="llvm::MCFragment::MCFragment", NM="_ZN4llvm10MCFragmentC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm10MCFragmentC1ERKS0_")
  //</editor-fold>
  protected/*private*/ MCFragment(final /*const*/ MCFragment /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::MCFragment::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 29,
   FQN="llvm::MCFragment::operator=", NM="_ZN4llvm10MCFragmentaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm10MCFragmentaSERKS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ MCFragment /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCFragment::FragmentType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 32,
   FQN="llvm::MCFragment::FragmentType", NM="_ZN4llvm10MCFragment12FragmentTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm10MCFragment12FragmentTypeE")
  //</editor-fold>
  public enum FragmentType/* : uint8_t*/ implements Native.NativeUCharEnum {
    FT_Align(0),
    FT_Data(FT_Align.getValue() + 1),
    FT_CompactEncodedInst(FT_Data.getValue() + 1),
    FT_Fill(FT_CompactEncodedInst.getValue() + 1),
    FT_Relaxable(FT_Fill.getValue() + 1),
    FT_Org(FT_Relaxable.getValue() + 1),
    FT_Dwarf(FT_Org.getValue() + 1),
    FT_DwarfFrame(FT_Dwarf.getValue() + 1),
    FT_LEB(FT_DwarfFrame.getValue() + 1),
    FT_SafeSEH(FT_LEB.getValue() + 1),
    FT_CVInlineLines(FT_SafeSEH.getValue() + 1),
    FT_CVDefRange(FT_CVInlineLines.getValue() + 1),
    FT_Dummy(FT_CVDefRange.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static FragmentType valueOf(byte/*uint8_t*/ val) {
      FragmentType out = valueOf((int)val);
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]. Int not capable to keep values?";
      return out;
    }
    public static FragmentType valueOf(int val) {
      FragmentType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final FragmentType[] VALUES;
      private static final FragmentType[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (FragmentType kind : FragmentType.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new FragmentType[min < 0 ? (1-min) : 0];
        VALUES = new FragmentType[max >= 0 ? (1+max) : 0];
        for (FragmentType kind : FragmentType.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final byte/*uint8_t*/ value;
    private FragmentType(int val) { this.value = (byte/*uint8_t*/)val;}
    @Override public final byte/*uint8_t*/ getValue() { return value;}
    //</editor-fold>
  };
/*private:*/
  private FragmentType Kind;
/*protected:*/
  protected boolean HasInstructions;
/*private:*/
  /// \brief Should this fragment be aligned to the end of a bundle?
  private boolean AlignToBundleEnd;
  
  private byte/*uint8_t*/ BundlePadding;
  
  /// LayoutOrder - The layout order of this fragment.
  private /*uint*/int LayoutOrder;
  
  /// The data for the section this fragment is in.
  private MCSection /*P*/ Parent;
  
  /// Atom - The atom this fragment is in, as represented by it's defining
  /// symbol.
  private /*const*/ MCSymbol /*P*/ Atom;
  
  /// \name Assembler Backend Data
  /// @{
  //
  // FIXME: This could all be kept private to the assembler implementation.
  
  /// Offset - The offset of this fragment in its section. This is ~0 until
  /// initialized.
  public long/*uint64_t*/ Offset;

  /// @}
  /*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCFragment::MCFragment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp", line = 244,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp", old_line = 245,
   FQN="llvm::MCFragment::MCFragment", NM="_ZN4llvm10MCFragmentC1ENS0_12FragmentTypeEbhPNS_9MCSectionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm10MCFragmentC1ENS0_12FragmentTypeEbhPNS_9MCSectionE")
  //</editor-fold>
  protected MCFragment(FragmentType Kind, boolean HasInstructions, 
      byte/*uint8_t*/ BundlePadding) {
    this(Kind, HasInstructions, 
      BundlePadding, (MCSection /*P*/ )null);
  }
  protected MCFragment(FragmentType Kind, boolean HasInstructions, 
      byte/*uint8_t*/ BundlePadding, MCSection /*P*/ Parent/*= null*/) {
    // : ilist_node_with_parent<MCFragment, MCSection>(), Kind(Kind), HasInstructions(HasInstructions), AlignToBundleEnd(false), BundlePadding(BundlePadding), Parent(Parent), Atom(null), Offset(~0ULL) 
    //START JInit
    this.ilist_node$Flds = $ilist_node_with_parent();
    this.Kind = Kind;
    this.HasInstructions = HasInstructions;
    this.AlignToBundleEnd = false;
    this.BundlePadding = BundlePadding;
    this.Parent = Parent;
    this.Atom = null;
    this.Offset = ~0L/*ULL*/;
    //END JInit
    if ((Parent != null) && !isDummy()) {
      Parent.getFragmentList().push_back(this);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCFragment::~MCFragment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp", line = 242,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp", old_line = 243,
   FQN="llvm::MCFragment::~MCFragment", NM="_ZN4llvm10MCFragmentD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm10MCFragmentD0Ev")
  //</editor-fold>
  public/*protected*/ void $destroy() {
    ilist_node_with_parent.super.$destroy$ilist_node();
  }

/*private:*/
  
  // This is a friend so that the sentinal can be created.
  /*friend  struct ilist_sentinel_traits<MCFragment>*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCFragment::MCFragment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp", line = 238,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp", old_line = 239,
   FQN="llvm::MCFragment::MCFragment", NM="_ZN4llvm10MCFragmentC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm10MCFragmentC1Ev")
  //</editor-fold>
  public MCFragment() {
    // : ilist_node_with_parent<MCFragment, MCSection>(), Kind(FragmentType(~0)), HasInstructions(false), AlignToBundleEnd(false), BundlePadding(0) 
    //START JInit
    this.ilist_node$Flds = $ilist_node_with_parent();
    this.Kind = FragmentType.valueOf(~0);
    this.HasInstructions = false;
    this.AlignToBundleEnd = false;
    this.BundlePadding = $int2uchar(0);
    //END JInit
  }

/*public:*/
  /// Destroys the current fragment.
  ///
  /// This must be used instead of delete as MCFragment is non-virtual.
  /// This method will dispatch to the appropriate subclass.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCFragment::destroy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp", line = 253,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp", old_line = 254,
   FQN="llvm::MCFragment::destroy", NM="_ZN4llvm10MCFragment7destroyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm10MCFragment7destroyEv")
  //</editor-fold>
  public void destroy() {
    // First check if we are the sentinal.
    if (Kind == FragmentType.valueOf(~0)) {
      if (this != null) { this.$destroy();};
      return;
    }
    switch (Kind) {
     case FT_Align:
      if (cast_MCAlignFragment(this) != null) { cast_MCAlignFragment(this).$destroy();};
      return;
     case FT_Data:
      if (cast_MCDataFragment(this) != null) { cast_MCDataFragment(this).$destroy();};
      return;
     case FT_CompactEncodedInst:
      if (cast_MCCompactEncodedInstFragment(this) != null) { cast_MCCompactEncodedInstFragment(this).$destroy();};
      return;
     case FT_Fill:
      if (cast_MCFillFragment(this) != null) { cast_MCFillFragment(this).$destroy();};
      return;
     case FT_Relaxable:
      if (cast_MCRelaxableFragment(this) != null) { cast_MCRelaxableFragment(this).$destroy();};
      return;
     case FT_Org:
      if (cast_MCOrgFragment(this) != null) { cast_MCOrgFragment(this).$destroy();};
      return;
     case FT_Dwarf:
      if (cast_MCDwarfLineAddrFragment(this) != null) { cast_MCDwarfLineAddrFragment(this).$destroy();};
      return;
     case FT_DwarfFrame:
      if (cast_MCDwarfCallFrameFragment(this) != null) { cast_MCDwarfCallFrameFragment(this).$destroy();};
      return;
     case FT_LEB:
      if (cast_MCLEBFragment(this) != null) { cast_MCLEBFragment(this).$destroy();};
      return;
     case FT_SafeSEH:
      if (cast_MCSafeSEHFragment(this) != null) { cast_MCSafeSEHFragment(this).$destroy();};
      return;
     case FT_CVInlineLines:
      if (cast_MCCVInlineLineTableFragment(this) != null) { cast_MCCVInlineLineTableFragment(this).$destroy();};
      return;
     case FT_CVDefRange:
      if (cast_MCCVDefRangeFragment(this) != null) { cast_MCCVDefRangeFragment(this).$destroy();};
      return;
     case FT_Dummy:
      if (cast_MCDummyFragment(this) != null) { cast_MCDummyFragment(this).$destroy();};
      return;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCFragment::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 99,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 97,
   FQN="llvm::MCFragment::getKind", NM="_ZNK4llvm10MCFragment7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZNK4llvm10MCFragment7getKindEv")
  //</editor-fold>
  public FragmentType getKind() /*const*/ {
    return Kind;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCFragment::getParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 101,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 99,
   FQN="llvm::MCFragment::getParent", NM="_ZNK4llvm10MCFragment9getParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZNK4llvm10MCFragment9getParentEv")
  //</editor-fold>
  public MCSection /*P*/ getParent() /*const*/ {
    return Parent;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCFragment::setParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 102,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 100,
   FQN="llvm::MCFragment::setParent", NM="_ZN4llvm10MCFragment9setParentEPNS_9MCSectionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm10MCFragment9setParentEPNS_9MCSectionE")
  //</editor-fold>
  public void setParent(MCSection /*P*/ Value) {
    Parent = Value;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCFragment::getAtom">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 104,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 102,
   FQN="llvm::MCFragment::getAtom", NM="_ZNK4llvm10MCFragment7getAtomEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZNK4llvm10MCFragment7getAtomEv")
  //</editor-fold>
  public /*const*/ MCSymbol /*P*/ getAtom() /*const*/ {
    return Atom;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCFragment::setAtom">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 105,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 103,
   FQN="llvm::MCFragment::setAtom", NM="_ZN4llvm10MCFragment7setAtomEPKNS_8MCSymbolE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm10MCFragment7setAtomEPKNS_8MCSymbolE")
  //</editor-fold>
  public void setAtom(/*const*/ MCSymbol /*P*/ Value) {
    Atom = Value;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCFragment::getLayoutOrder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 107,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 105,
   FQN="llvm::MCFragment::getLayoutOrder", NM="_ZNK4llvm10MCFragment14getLayoutOrderEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZNK4llvm10MCFragment14getLayoutOrderEv")
  //</editor-fold>
  public /*uint*/int getLayoutOrder() /*const*/ {
    return LayoutOrder;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCFragment::setLayoutOrder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 108,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 106,
   FQN="llvm::MCFragment::setLayoutOrder", NM="_ZN4llvm10MCFragment14setLayoutOrderEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm10MCFragment14setLayoutOrderEj")
  //</editor-fold>
  public void setLayoutOrder(/*uint*/int Value) {
    LayoutOrder = Value;
  }

  
  /// \brief Does this fragment have instructions emitted into it? By default
  /// this is false, but specific fragment types may set it to true.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCFragment::hasInstructions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 112,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 110,
   FQN="llvm::MCFragment::hasInstructions", NM="_ZNK4llvm10MCFragment15hasInstructionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZNK4llvm10MCFragment15hasInstructionsEv")
  //</editor-fold>
  public boolean hasInstructions() /*const*/ {
    return HasInstructions;
  }

  
  /// \brief Should this fragment be placed at the end of an aligned bundle?
  //<editor-fold defaultstate="collapsed" desc="llvm::MCFragment::alignToBundleEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 115,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 113,
   FQN="llvm::MCFragment::alignToBundleEnd", NM="_ZNK4llvm10MCFragment16alignToBundleEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZNK4llvm10MCFragment16alignToBundleEndEv")
  //</editor-fold>
  public boolean alignToBundleEnd() /*const*/ {
    return AlignToBundleEnd;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCFragment::setAlignToBundleEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 116,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 114,
   FQN="llvm::MCFragment::setAlignToBundleEnd", NM="_ZN4llvm10MCFragment19setAlignToBundleEndEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm10MCFragment19setAlignToBundleEndEb")
  //</editor-fold>
  public void setAlignToBundleEnd(boolean V) {
    AlignToBundleEnd = V;
  }

  
  /// \brief Get the padding size that must be inserted before this fragment.
  /// Used for bundling. By default, no padding is inserted.
  /// Note that padding size is restricted to 8 bits. This is an optimization
  /// to reduce the amount of space used for each fragment. In practice, larger
  /// padding should never be required.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCFragment::getBundlePadding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 123,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 121,
   FQN="llvm::MCFragment::getBundlePadding", NM="_ZNK4llvm10MCFragment16getBundlePaddingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZNK4llvm10MCFragment16getBundlePaddingEv")
  //</editor-fold>
  public byte/*uint8_t*/ getBundlePadding() /*const*/ {
    return BundlePadding;
  }

  
  /// \brief Set the padding size for this fragment. By default it's a no-op,
  /// and only some fragments have a meaningful implementation.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCFragment::setBundlePadding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 127,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 125,
   FQN="llvm::MCFragment::setBundlePadding", NM="_ZN4llvm10MCFragment16setBundlePaddingEh",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm10MCFragment16setBundlePaddingEh")
  //</editor-fold>
  public void setBundlePadding(byte/*uint8_t*/ N) {
    BundlePadding = N;
  }

  
  /// \brief Return true if given frgment has FT_Dummy type.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCFragment::isDummy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", line = 130,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFragment.h", old_line = 128,
   FQN="llvm::MCFragment::isDummy", NM="_ZNK4llvm10MCFragment7isDummyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZNK4llvm10MCFragment7isDummyEv")
  //</editor-fold>
  public boolean isDummy() /*const*/ {
    return Kind == FragmentType.FT_Dummy;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCFragment::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp", line = 319,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp", old_line = 314,
   FQN="llvm::MCFragment::dump", NM="_ZN4llvm10MCFragment4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm10MCFragment4dumpEv")
  //</editor-fold>
  public void dump()/* __attribute__((used)) __attribute__((noinline))*/ {
    final raw_ostream /*&*/ OS = llvm.errs();
    
    OS.$out(/*KEEP_STR*/$LT);
    switch (getKind()) {
     case FT_Align:
      OS.$out(/*KEEP_STR*/"MCAlignFragment");
      break;
     case FT_Data:
      OS.$out(/*KEEP_STR*/"MCDataFragment");
      break;
     case FT_CompactEncodedInst:
      OS.$out(/*KEEP_STR*/"MCCompactEncodedInstFragment");
      break;
     case FT_Fill:
      OS.$out(/*KEEP_STR*/"MCFillFragment");
      break;
     case FT_Relaxable:
      OS.$out(/*KEEP_STR*/"MCRelaxableFragment");
      break;
     case FT_Org:
      OS.$out(/*KEEP_STR*/"MCOrgFragment");
      break;
     case FT_Dwarf:
      OS.$out(/*KEEP_STR*/"MCDwarfFragment");
      break;
     case FT_DwarfFrame:
      OS.$out(/*KEEP_STR*/"MCDwarfCallFrameFragment");
      break;
     case FT_LEB:
      OS.$out(/*KEEP_STR*/"MCLEBFragment");
      break;
     case FT_SafeSEH:
      OS.$out(/*KEEP_STR*/"MCSafeSEHFragment");
      break;
     case FT_CVInlineLines:
      OS.$out(/*KEEP_STR*/"MCCVInlineLineTableFragment");
      break;
     case FT_CVDefRange:
      OS.$out(/*KEEP_STR*/"MCCVDefRangeTableFragment");
      break;
     case FT_Dummy:
      OS.$out(/*KEEP_STR*/"MCDummyFragment");
      break;
    }
    
    OS.$out(/*KEEP_STR*/"<MCFragment ").$out(reinterpret_cast(Object/*void P*/ .class, this)).$out(/*KEEP_STR*/" LayoutOrder:").$out_uint(LayoutOrder).$out(
        /*KEEP_STR*/" Offset:"
    ).$out_ullong(Offset).$out(
        /*KEEP_STR*/" HasInstructions:"
    ).$out_int((hasInstructions() ? 1 : 0)).$out(
        /*KEEP_STR*/" BundlePadding:"
    ).$out_uint(((/*static_cast*//*uint*/int)($uchar2uint(getBundlePadding())))).$out(/*KEEP_STR*/$GT);
    switch (getKind()) {
     case FT_Align:
      {
        /*const*/ MCAlignFragment /*P*/ AF = cast_MCAlignFragment(this);
        if (AF.hasEmitNops()) {
          OS.$out(/*KEEP_STR*/" (emit nops)");
        }
        OS.$out(/*KEEP_STR*/"\n       ");
        OS.$out(/*KEEP_STR*/" Alignment:").$out_uint(AF.getAlignment()).$out(
            /*KEEP_STR*/" Value:"
        ).$out_llong(AF.getValue()).$out(/*KEEP_STR*/" ValueSize:").$out_uint(AF.getValueSize()).$out(
            /*KEEP_STR*/" MaxBytesToEmit:"
        ).$out_uint(AF.getMaxBytesToEmit()).$out(/*KEEP_STR*/$GT);
        break;
      }
     case FT_Data:
      {
        /*const*/ MCDataFragment /*P*/ DF = cast_MCDataFragment(this);
        OS.$out(/*KEEP_STR*/"\n       ");
        OS.$out(/*KEEP_STR*/" Contents:[");
        final /*const*/SmallString/*&*/ Contents = DF.getContents$Const();
        for (/*uint*/int i = 0, e = Contents.size(); i != e; ++i) {
          if ((i != 0)) {
            OS.$out(/*KEEP_STR*/$COMMA);
          }
          OS.$out_char(AdtsupportLlvmGlobals.hexdigit((Contents.$at$Const(i) >> 4) & 0xF)).$out_char(AdtsupportLlvmGlobals.hexdigit(Contents.$at$Const(i) & 0xF));
        }
        OS.$out(/*KEEP_STR*/"] (").$out_uint(Contents.size()).$out(/*KEEP_STR*/" bytes)");
        if ($noteq_ptr(DF.fixup_begin$Const(), DF.fixup_end$Const())) {
          OS.$out(/*KEEP_STR*/",\n       ");
          OS.$out(/*KEEP_STR*/" Fixups:[");
          for (type$ptr<MCFixup> it = $tryClone(DF.fixup_begin$Const()), 
              /*P*/ ie = $tryClone(DF.fixup_end$Const()); $noteq_ptr(it, ie); it.$preInc()) {
            if ($noteq_ptr(it, DF.fixup_begin$Const())) {
              OS.$out(/*KEEP_STR*/",\n                ");
            }
            $out_raw_ostream_MCFixup$C(OS, it.$star());
          }
          OS.$out(/*KEEP_STR*/$RSQUARE);
        }
        break;
      }
     case FT_CompactEncodedInst:
      {
        /*const*/ MCCompactEncodedInstFragment /*P*/ CEIF = cast_MCCompactEncodedInstFragment(this);
        OS.$out(/*KEEP_STR*/"\n       ");
        OS.$out(/*KEEP_STR*/" Contents:[");
        final /*const*/SmallString/*&*/ Contents = CEIF.getContents$Const();
        for (/*uint*/int i = 0, e = Contents.size(); i != e; ++i) {
          if ((i != 0)) {
            OS.$out(/*KEEP_STR*/$COMMA);
          }
          OS.$out_char(AdtsupportLlvmGlobals.hexdigit((Contents.$at$Const(i) >> 4) & 0xF)).$out_char(AdtsupportLlvmGlobals.hexdigit(Contents.$at$Const(i) & 0xF));
        }
        OS.$out(/*KEEP_STR*/"] (").$out_uint(Contents.size()).$out(/*KEEP_STR*/" bytes)");
        break;
      }
     case FT_Fill:
      {
        /*const*/ MCFillFragment /*P*/ FF = cast_MCFillFragment(this);
        OS.$out(/*KEEP_STR*/" Value:").$out_uchar(FF.getValue()).$out(/*KEEP_STR*/" Size:").$out_ullong(FF.getSize());
        break;
      }
     case FT_Relaxable:
      {
        /*const*/ MCRelaxableFragment /*P*/ F = cast_MCRelaxableFragment(this);
        OS.$out(/*KEEP_STR*/"\n       ");
        OS.$out(/*KEEP_STR*/" Inst:");
        F.getInst().dump_pretty(OS);
        break;
      }
     case FT_Org:
      {
        /*const*/ MCOrgFragment /*P*/ OF = cast_MCOrgFragment(this);
        OS.$out(/*KEEP_STR*/"\n       ");
        $out_raw_ostream_MCExpr$C(OS.$out(/*KEEP_STR*/" Offset:"), OF.getOffset()).$out(/*KEEP_STR*/" Value:").$out_uchar(OF.getValue());
        break;
      }
     case FT_Dwarf:
      {
        /*const*/ MCDwarfLineAddrFragment /*P*/ OF = cast_MCDwarfLineAddrFragment(this);
        OS.$out(/*KEEP_STR*/"\n       ");
        $out_raw_ostream_MCExpr$C(OS.$out(/*KEEP_STR*/" AddrDelta:"), OF.getAddrDelta()).$out(
            /*KEEP_STR*/" LineDelta:"
        ).$out_llong(OF.getLineDelta());
        break;
      }
     case FT_DwarfFrame:
      {
        /*const*/ MCDwarfCallFrameFragment /*P*/ CF = cast_MCDwarfCallFrameFragment(this);
        OS.$out(/*KEEP_STR*/"\n       ");
        $out_raw_ostream_MCExpr$C(OS.$out(/*KEEP_STR*/" AddrDelta:"), CF.getAddrDelta());
        break;
      }
     case FT_LEB:
      {
        /*const*/ MCLEBFragment /*P*/ LF = cast_MCLEBFragment(this);
        OS.$out(/*KEEP_STR*/"\n       ");
        $out_raw_ostream_MCExpr$C(OS.$out(/*KEEP_STR*/" Value:"), LF.getValue()).$out(/*KEEP_STR*/" Signed:").$out_int((LF.isSigned() ? 1 : 0));
        break;
      }
     case FT_SafeSEH:
      {
        /*const*/ MCSafeSEHFragment /*P*/ F = cast_MCSafeSEHFragment(this);
        OS.$out(/*KEEP_STR*/"\n       ");
        OS.$out(/*KEEP_STR*/" Sym:").$out(F.getSymbol$Const());
        break;
      }
     case FT_CVInlineLines:
      {
        /*const*/ MCCVInlineLineTableFragment /*P*/ F = cast_MCCVInlineLineTableFragment(this);
        OS.$out(/*KEEP_STR*/"\n       ");
        $out_raw_ostream_MCSymbol$C(OS.$out(/*KEEP_STR*/" Sym:"), $Deref(F.getFnStartSym()));
        break;
      }
     case FT_CVDefRange:
      {
        /*const*/ MCCVDefRangeFragment /*P*/ F = cast_MCCVDefRangeFragment(this);
        OS.$out(/*KEEP_STR*/"\n       ");
        for (std.pairPtrPtr</*const*/ MCSymbol /*P*/ , /*const*/ MCSymbol /*P*/ > RangeStartEnd : F.getRanges()) {
          OS.$out(/*KEEP_STR*/" RangeStart:").$out(RangeStartEnd.first);
          OS.$out(/*KEEP_STR*/" RangeEnd:").$out(RangeStartEnd.second);
        }
        break;
      }
     case FT_Dummy:
      break;
    }
    OS.$out(/*KEEP_STR*/$GT);
  }

  
  private final ilist_node$Fields ilist_node$Flds;// use return value of $ilist_node_with_parent();
  @Override public final ilist_node$Fields $ilist_node$Fields() { return ilist_node$Flds; }
  
  @Override public String toString() {
    return "" + "Kind=" + Kind // NOI18N
              + ", HasInstructions=" + HasInstructions // NOI18N
              + ", AlignToBundleEnd=" + AlignToBundleEnd // NOI18N
              + ", BundlePadding=" + $uchar2uint(BundlePadding) // NOI18N
              + ", LayoutOrder=" + LayoutOrder // NOI18N
              + ", Parent=" + Parent // NOI18N
              + ", Atom=" + Atom // NOI18N
              + ", Offset=" + Offset // NOI18N
              + super.toString(); // NOI18N
  }
}
