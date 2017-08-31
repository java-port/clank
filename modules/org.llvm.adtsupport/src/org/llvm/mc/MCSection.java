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

import java.util.Iterator;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;


/// Instances of this class represent a uniqued identifier for a section in the
/// current translation unit.  The MCContext class uniques and creates these.
//<editor-fold defaultstate="collapsed" desc="llvm::MCSection">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", line = 48,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", old_line = 49,
 FQN="llvm::MCSection", NM="_ZN4llvm9MCSectionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZN4llvm9MCSectionE")
//</editor-fold>
public abstract class MCSection implements Iterable<MCFragment>, Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSection::SectionVariant">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", line = 50,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", old_line = 51,
   FQN="llvm::MCSection::SectionVariant", NM="_ZN4llvm9MCSection14SectionVariantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZN4llvm9MCSection14SectionVariantE")
  //</editor-fold>
  public enum SectionVariant implements Native.NativeUIntEnum {
    SV_COFF(0),
    SV_ELF(SV_COFF.getValue() + 1),
    SV_MachO(SV_ELF.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static SectionVariant valueOf(int val) {
      SectionVariant out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final SectionVariant[] VALUES;
      private static final SectionVariant[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (SectionVariant kind : SectionVariant.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new SectionVariant[min < 0 ? (1-min) : 0];
        VALUES = new SectionVariant[max >= 0 ? (1+max) : 0];
        for (SectionVariant kind : SectionVariant.values()) {
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

    private final /*uint*/int value;
    private SectionVariant(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  /// \brief Express the state of bundle locked groups while emitting code.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSection::BundleLockStateType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", line = 53,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", old_line = 54,
   FQN="llvm::MCSection::BundleLockStateType", NM="_ZN4llvm9MCSection19BundleLockStateTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZN4llvm9MCSection19BundleLockStateTypeE")
  //</editor-fold>
  public enum BundleLockStateType implements Native.NativeUIntEnum {
    NotBundleLocked(0),
    BundleLocked(NotBundleLocked.getValue() + 1),
    BundleLockedAlignToEnd(BundleLocked.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static BundleLockStateType valueOf(int val) {
      BundleLockStateType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final BundleLockStateType[] VALUES;
      private static final BundleLockStateType[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (BundleLockStateType kind : BundleLockStateType.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new BundleLockStateType[min < 0 ? (1-min) : 0];
        VALUES = new BundleLockStateType[max >= 0 ? (1+max) : 0];
        for (BundleLockStateType kind : BundleLockStateType.values()) {
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

    private final /*uint*/int value;
    private BundleLockStateType(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  // JAVA: typedef iplist<MCFragment> FragmentListType
//  public final class FragmentListType extends iplist<MCFragment>{ };
  
  // JAVA: typedef FragmentListType::const_iterator const_iterator
//  public final class const_iterator extends ilist_iterator</*const*/ MCFragment>{ };
  // JAVA: typedef FragmentListType::iterator iterator
//  public final class iterator extends ilist_iterator<MCFragment>{ };
  
  // JAVA: typedef FragmentListType::const_reverse_iterator const_reverse_iterator
//  public final class const_reverse_iterator extends std.reverse_iterator</*const*/ MCFragment>{ };
  // JAVA: typedef FragmentListType::reverse_iterator reverse_iterator
//  public final class reverse_iterator extends std.reverse_iterator<MCFragment>{ };
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSection::MCSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", line = 68,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", old_line = 69,
   FQN="llvm::MCSection::MCSection", NM="_ZN4llvm9MCSectionC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZN4llvm9MCSectionC1ERKS0_")
  //</editor-fold>
  protected/*private*/ MCSection(final /*const*/ MCSection /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSection::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", line = 69,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", old_line = 70,
   FQN="llvm::MCSection::operator=", NM="_ZN4llvm9MCSectionaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZN4llvm9MCSectionaSERKS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ MCSection /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
  private MCSymbol /*P*/ Begin;
  private MCSymbol /*P*/ End/* = null*/;
  /// The alignment requirement of this section.
  private /*uint*/int Alignment/* = 1*/;
  /// The section index in the assemblers section list.
  private /*uint*/int Ordinal/* = 0*/;
  /// The index of this section in the layout order.
  private /*uint*/int LayoutOrder;
  
  /// \brief Keeping track of bundle-locked state.
  private BundleLockStateType BundleLockState/* = NotBundleLocked*/;
  
  /// \brief Current nesting depth of bundle_lock directives.
  private /*uint*/int BundleLockNestingDepth/* = 0*/;
  
  /// \brief We've seen a bundle_lock directive but not its first instruction
  /// yet.
  private /*JBIT unsigned int*/ boolean BundleGroupBeforeFirstInst /*: 1*/;
  
  /// Whether this section has had instructions emitted into it.
  private /*JBIT unsigned int*/ boolean HasInstructions /*: 1*/;
  
  private /*JBIT unsigned int*/ boolean IsRegistered /*: 1*/;
  
  private MCDummyFragment DummyFragment;
  
  private iplist<MCFragment> Fragments;
  
  /// Mapping from subsection number to insertion point for subsection numbers
  /// below that number.
  private SmallVector<std.pairUIntPtr<MCFragment /*P*/ >> SubsectionFragmentMap;
/*protected:*/
  
  //===----------------------------------------------------------------------===//
  // MCSection
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSection::MCSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSection.cpp", line = 22,
   FQN="llvm::MCSection::MCSection", NM="_ZN4llvm9MCSectionC1ENS0_14SectionVariantENS_11SectionKindEPNS_8MCSymbolE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZN4llvm9MCSectionC1ENS0_14SectionVariantENS_11SectionKindEPNS_8MCSymbolE")
  //</editor-fold>
  protected MCSection(SectionVariant V, SectionKind K, MCSymbol /*P*/ Begin) {
    // : Begin(Begin), End(null), Alignment(1), Ordinal(0), BundleLockState(NotBundleLocked), BundleLockNestingDepth(0), BundleGroupBeforeFirstInst(false), HasInstructions(false), IsRegistered(false), DummyFragment(this), Fragments(), SubsectionFragmentMap(), Variant(V), Kind(K) 
    //START JInit
    this.Begin = Begin;
    /*InClass*/this.End = null;
    /*InClass*/this.Alignment = 1;
    /*InClass*/this.Ordinal = 0;
    /*InClass*/this.BundleLockState = BundleLockStateType.NotBundleLocked;
    /*InClass*/this.BundleLockNestingDepth = 0;
    this.BundleGroupBeforeFirstInst = false;
    this.HasInstructions = false;
    this.IsRegistered = false;
    this.DummyFragment = new MCDummyFragment(this);
    this.Fragments = new ilistMCFragment();
    this.SubsectionFragmentMap = new SmallVector<std.pairUIntPtr<MCFragment /*P*/ >>(1, new std.pairUIntPtr<MCFragment /*P*/ >());
    this.Variant = V;
    this.Kind = new SectionKind(K);
    //END JInit
  }

  protected SectionVariant Variant;
  protected SectionKind Kind;
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSection::~MCSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSection.cpp", line = 34,
   FQN="llvm::MCSection::~MCSection", NM="_ZN4llvm9MCSectionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZN4llvm9MCSectionD0Ev")
  //</editor-fold>
  public/*protected*/ void $destroy() {
    //START JDestroy
    SubsectionFragmentMap.$destroy();
    Fragments.$destroy();
    DummyFragment.$destroy();
    //END JDestroy
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSection::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", line = 110,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", old_line = 111,
   FQN="llvm::MCSection::getKind", NM="_ZNK4llvm9MCSection7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZNK4llvm9MCSection7getKindEv")
  //</editor-fold>
  public SectionKind getKind() /*const*/ {
    return new SectionKind(Kind);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSection::getVariant">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", line = 112,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", old_line = 113,
   FQN="llvm::MCSection::getVariant", NM="_ZNK4llvm9MCSection10getVariantEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZNK4llvm9MCSection10getVariantEv")
  //</editor-fold>
  public SectionVariant getVariant() /*const*/ {
    return Variant;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSection::getBeginSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", line = 114,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", old_line = 115,
   FQN="llvm::MCSection::getBeginSymbol", NM="_ZN4llvm9MCSection14getBeginSymbolEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZN4llvm9MCSection14getBeginSymbolEv")
  //</editor-fold>
  public MCSymbol /*P*/ getBeginSymbol() {
    return Begin;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSection::getBeginSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", line = 115,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", old_line = 116,
   FQN="llvm::MCSection::getBeginSymbol", NM="_ZNK4llvm9MCSection14getBeginSymbolEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZNK4llvm9MCSection14getBeginSymbolEv")
  //</editor-fold>
  public /*const*/ MCSymbol /*P*/ getBeginSymbol$Const() /*const*/ {
    return ((/*const_cast*/MCSection /*P*/ )(this)).getBeginSymbol();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSection::setBeginSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", line = 118,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", old_line = 119,
   FQN="llvm::MCSection::setBeginSymbol", NM="_ZN4llvm9MCSection14setBeginSymbolEPNS_8MCSymbolE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZN4llvm9MCSection14setBeginSymbolEPNS_8MCSymbolE")
  //</editor-fold>
  public void setBeginSymbol(MCSymbol /*P*/ Sym) {
    assert (!(Begin != null));
    Begin = Sym;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSection::getEndSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSection.cpp", line = 26,
   FQN="llvm::MCSection::getEndSymbol", NM="_ZN4llvm9MCSection12getEndSymbolERNS_9MCContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZN4llvm9MCSection12getEndSymbolERNS_9MCContextE")
  //</editor-fold>
  public MCSymbol /*P*/ getEndSymbol(final MCContext /*&*/ Ctx) {
    if (!(End != null)) {
      End = Ctx.createTempSymbol(new Twine(/*KEEP_STR*/"sec_end"), true);
    }
    return End;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSection::hasEnded">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSection.cpp", line = 32,
   FQN="llvm::MCSection::hasEnded", NM="_ZNK4llvm9MCSection8hasEndedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZNK4llvm9MCSection8hasEndedEv")
  //</editor-fold>
  public boolean hasEnded() /*const*/ {
    return (End != null) && End.isInSection();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSection::getAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", line = 125,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", old_line = 126,
   FQN="llvm::MCSection::getAlignment", NM="_ZNK4llvm9MCSection12getAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZNK4llvm9MCSection12getAlignmentEv")
  //</editor-fold>
  public /*uint*/int getAlignment() /*const*/ {
    return Alignment;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSection::setAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", line = 126,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", old_line = 127,
   FQN="llvm::MCSection::setAlignment", NM="_ZN4llvm9MCSection12setAlignmentEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZN4llvm9MCSection12setAlignmentEj")
  //</editor-fold>
  public void setAlignment(/*uint*/int Value) {
    Alignment = Value;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSection::getOrdinal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", line = 128,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", old_line = 129,
   FQN="llvm::MCSection::getOrdinal", NM="_ZNK4llvm9MCSection10getOrdinalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZNK4llvm9MCSection10getOrdinalEv")
  //</editor-fold>
  public /*uint*/int getOrdinal() /*const*/ {
    return Ordinal;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSection::setOrdinal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", line = 129,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", old_line = 130,
   FQN="llvm::MCSection::setOrdinal", NM="_ZN4llvm9MCSection10setOrdinalEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZN4llvm9MCSection10setOrdinalEj")
  //</editor-fold>
  public void setOrdinal(/*uint*/int Value) {
    Ordinal = Value;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSection::getLayoutOrder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", line = 131,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", old_line = 132,
   FQN="llvm::MCSection::getLayoutOrder", NM="_ZNK4llvm9MCSection14getLayoutOrderEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZNK4llvm9MCSection14getLayoutOrderEv")
  //</editor-fold>
  public /*uint*/int getLayoutOrder() /*const*/ {
    return LayoutOrder;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSection::setLayoutOrder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", line = 132,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", old_line = 133,
   FQN="llvm::MCSection::setLayoutOrder", NM="_ZN4llvm9MCSection14setLayoutOrderEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZN4llvm9MCSection14setLayoutOrderEj")
  //</editor-fold>
  public void setLayoutOrder(/*uint*/int Value) {
    LayoutOrder = Value;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSection::getBundleLockState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", line = 134,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", old_line = 135,
   FQN="llvm::MCSection::getBundleLockState", NM="_ZNK4llvm9MCSection18getBundleLockStateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZNK4llvm9MCSection18getBundleLockStateEv")
  //</editor-fold>
  public BundleLockStateType getBundleLockState() /*const*/ {
    return BundleLockState;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSection::setBundleLockState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSection.cpp", line = 37,
   FQN="llvm::MCSection::setBundleLockState", NM="_ZN4llvm9MCSection18setBundleLockStateENS0_19BundleLockStateTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZN4llvm9MCSection18setBundleLockStateENS0_19BundleLockStateTypeE")
  //</editor-fold>
  public void setBundleLockState(BundleLockStateType NewState) {
    if (NewState == BundleLockStateType.NotBundleLocked) {
      if (BundleLockNestingDepth == 0) {
        report_fatal_error($("Mismatched bundle_lock/unlock directives"));
      }
      if (--BundleLockNestingDepth == 0) {
        BundleLockState = BundleLockStateType.NotBundleLocked;
      }
      return;
    }
    
    // If any of the directives is an align_to_end directive, the whole nested
    // group is align_to_end. So don't downgrade from align_to_end to just locked.
    if (BundleLockState != BundleLockStateType.BundleLockedAlignToEnd) {
      BundleLockState = NewState;
    }
    ++BundleLockNestingDepth;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSection::isBundleLocked">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", line = 136,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", old_line = 137,
   FQN="llvm::MCSection::isBundleLocked", NM="_ZNK4llvm9MCSection14isBundleLockedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZNK4llvm9MCSection14isBundleLockedEv")
  //</editor-fold>
  public boolean isBundleLocked() /*const*/ {
    return BundleLockState != BundleLockStateType.NotBundleLocked;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSection::isBundleGroupBeforeFirstInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", line = 138,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", old_line = 139,
   FQN="llvm::MCSection::isBundleGroupBeforeFirstInst", NM="_ZNK4llvm9MCSection28isBundleGroupBeforeFirstInstEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZNK4llvm9MCSection28isBundleGroupBeforeFirstInstEv")
  //</editor-fold>
  public boolean isBundleGroupBeforeFirstInst() /*const*/ {
    return BundleGroupBeforeFirstInst;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSection::setBundleGroupBeforeFirstInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", line = 141,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", old_line = 142,
   FQN="llvm::MCSection::setBundleGroupBeforeFirstInst", NM="_ZN4llvm9MCSection29setBundleGroupBeforeFirstInstEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZN4llvm9MCSection29setBundleGroupBeforeFirstInstEb")
  //</editor-fold>
  public void setBundleGroupBeforeFirstInst(boolean IsFirst) {
    BundleGroupBeforeFirstInst = IsFirst;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSection::hasInstructions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", line = 145,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", old_line = 146,
   FQN="llvm::MCSection::hasInstructions", NM="_ZNK4llvm9MCSection15hasInstructionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZNK4llvm9MCSection15hasInstructionsEv")
  //</editor-fold>
  public boolean hasInstructions() /*const*/ {
    return HasInstructions;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSection::setHasInstructions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", line = 146,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", old_line = 147,
   FQN="llvm::MCSection::setHasInstructions", NM="_ZN4llvm9MCSection18setHasInstructionsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZN4llvm9MCSection18setHasInstructionsEb")
  //</editor-fold>
  public void setHasInstructions(boolean Value) {
    HasInstructions = Value;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSection::isRegistered">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", line = 148,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", old_line = 149,
   FQN="llvm::MCSection::isRegistered", NM="_ZNK4llvm9MCSection12isRegisteredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZNK4llvm9MCSection12isRegisteredEv")
  //</editor-fold>
  public boolean isRegistered() /*const*/ {
    return IsRegistered;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSection::setIsRegistered">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", line = 149,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", old_line = 150,
   FQN="llvm::MCSection::setIsRegistered", NM="_ZN4llvm9MCSection15setIsRegisteredEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZN4llvm9MCSection15setIsRegisteredEb")
  //</editor-fold>
  public void setIsRegistered(boolean Value) {
    IsRegistered = Value;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSection::getFragmentList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", line = 151,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", old_line = 152,
   FQN="llvm::MCSection::getFragmentList", NM="_ZN4llvm9MCSection15getFragmentListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZN4llvm9MCSection15getFragmentListEv")
  //</editor-fold>
  public iplist<MCFragment> /*&*/ getFragmentList() {
    return Fragments;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSection::getFragmentList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", line = 152,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", old_line = 153,
   FQN="llvm::MCSection::getFragmentList", NM="_ZNK4llvm9MCSection15getFragmentListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZNK4llvm9MCSection15getFragmentListEv")
  //</editor-fold>
  public /*const*/ iplist<MCFragment> /*&*/ getFragmentList$Const() /*const*/ {
    return ((/*const_cast*/MCSection /*P*/ )(this)).getFragmentList();
  }

  
  /// Support for MCFragment::getNextNode().
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSection::getSublistAccess">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", line = 157,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", old_line = 158,
   FQN="llvm::MCSection::getSublistAccess", NM="_ZN4llvm9MCSection16getSublistAccessEPNS_10MCFragmentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZN4llvm9MCSection16getSublistAccessEPNS_10MCFragmentE")
  //</editor-fold>
  public static iplist<MCFragment> /*MCSection::**/getSublistAccess(MCSection $this, MCFragment /*P*/ $Prm0) {
    return $AddrOf($this.Fragments);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSection::getDummyFragment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", line = 161,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", old_line = 162,
   FQN="llvm::MCSection::getDummyFragment", NM="_ZNK4llvm9MCSection16getDummyFragmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZNK4llvm9MCSection16getDummyFragmentEv")
  //</editor-fold>
  public /*const*/ MCDummyFragment /*&*/ getDummyFragment$Const() /*const*/ {
    return DummyFragment;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSection::getDummyFragment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", line = 162,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", old_line = 163,
   FQN="llvm::MCSection::getDummyFragment", NM="_ZN4llvm9MCSection16getDummyFragmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZN4llvm9MCSection16getDummyFragmentEv")
  //</editor-fold>
  public MCDummyFragment /*&*/ getDummyFragment() {
    return DummyFragment;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSection::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSection.cpp", line = 103,
   FQN="llvm::MCSection::begin", NM="_ZN4llvm9MCSection5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZN4llvm9MCSection5beginEv")
  //</editor-fold>
  public ilist_iterator<MCFragment> begin() {
    return Fragments.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSection::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", line = 165,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", old_line = 166,
   FQN="llvm::MCSection::begin", NM="_ZNK4llvm9MCSection5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZNK4llvm9MCSection5beginEv")
  //</editor-fold>
  public ilist_iterator</*const*/ MCFragment> begin$Const() /*const*/ {
    return new ilist_iterator</*const*/ MCFragment>(((/*const_cast*/MCSection /*P*/ )(this)).begin());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSection::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSection.cpp", line = 105,
   FQN="llvm::MCSection::end", NM="_ZN4llvm9MCSection3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZN4llvm9MCSection3endEv")
  //</editor-fold>
  public ilist_iterator<MCFragment> end() {
    return Fragments.end();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSection::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", line = 170,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", old_line = 171,
   FQN="llvm::MCSection::end", NM="_ZNK4llvm9MCSection3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZNK4llvm9MCSection3endEv")
  //</editor-fold>
  public ilist_iterator</*const*/ MCFragment> end$Const() /*const*/ {
    return new ilist_iterator</*const*/ MCFragment>(((/*const_cast*/MCSection /*P*/ )(this)).end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSection::rbegin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSection.cpp", line = 107,
   FQN="llvm::MCSection::rbegin", NM="_ZN4llvm9MCSection6rbeginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZN4llvm9MCSection6rbeginEv")
  //</editor-fold>
  public std.reverse_iterator<MCFragment> rbegin() {
    return Fragments.rbegin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSection::rbegin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", line = 175,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", old_line = 176,
   FQN="llvm::MCSection::rbegin", NM="_ZNK4llvm9MCSection6rbeginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZNK4llvm9MCSection6rbeginEv")
  //</editor-fold>
  public std.reverse_iterator</*const*/ MCFragment> rbegin$Const() /*const*/ {
    return new std.reverse_iterator</*const*/ MCFragment>(JD$Reverse_iterator$_Iter$C.INSTANCE, ((/*const_cast*/MCSection /*P*/ )(this)).rbegin());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSection::rend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSection.cpp", line = 109,
   FQN="llvm::MCSection::rend", NM="_ZN4llvm9MCSection4rendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZN4llvm9MCSection4rendEv")
  //</editor-fold>
  public std.reverse_iterator<MCFragment> rend() {
    return Fragments.rend();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSection::rend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", line = 180,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", old_line = 181,
   FQN="llvm::MCSection::rend", NM="_ZNK4llvm9MCSection4rendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZNK4llvm9MCSection4rendEv")
  //</editor-fold>
  public std.reverse_iterator</*const*/ MCFragment> rend$Const() /*const*/ {
    return new std.reverse_iterator</*const*/ MCFragment>(JD$Reverse_iterator$_Iter$C.INSTANCE, ((/*const_cast*/MCSection /*P*/ )(this)).rend());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSection::getSubsectionInsertionPoint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSection.cpp", line = 56,
   FQN="llvm::MCSection::getSubsectionInsertionPoint", NM="_ZN4llvm9MCSection27getSubsectionInsertionPointEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZN4llvm9MCSection27getSubsectionInsertionPointEj")
  //</editor-fold>
  public ilist_iterator<MCFragment> getSubsectionInsertionPoint(/*uint*/int Subsection) {
    if (Subsection == 0 && SubsectionFragmentMap.empty()) {
      return end();
    }
    
    type$ptr<std.pairUIntPtr<MCFragment /*P*/ >> MI = std.lower_bound(SubsectionFragmentMap.begin(), 
        SubsectionFragmentMap.end(), 
        std.make_pair_uint_Ptr(Subsection, (MCFragment /*P*/ )(MCFragment /*P*/ )null));
    boolean ExactMatch = false;
    if ($noteq_ptr(MI, SubsectionFragmentMap.end())) {
      ExactMatch = MI./*->*/$star().first == Subsection;
      if (ExactMatch) {
        MI.$preInc();
      }
    }
    ilist_iterator<MCFragment> IP/*J*/= new ilist_iterator<MCFragment>(ilist_traitsMCFragment.$instance());
    if ($eq_ptr(MI, SubsectionFragmentMap.end())) {
      IP.$assignMove(end());
    } else {
      IP.$assignMove(((MCFragment)MI./*->*/$star().second).getIterator());
    }
    if (!ExactMatch && Subsection != 0) {
      // The GNU as documentation claims that subsections have an alignment of 4,
      // although this appears not to be the case.
      MCFragment /*P*/ F = new MCDataFragment();
      SubsectionFragmentMap.insert_iterator$T$value_T$RR(MI, std.make_pair_uint_Ptr(Subsection, F));
      getFragmentList().insert_ilist_iterator$NodeTy_T$P(new ilist_iterator<MCFragment>(IP), F);
      F.setParent(this);
    }
    
    return IP;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSection::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSection.cpp", line = 89,
   FQN="llvm::MCSection::dump", NM="_ZN4llvm9MCSection4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZN4llvm9MCSection4dumpEv")
  //</editor-fold>
  public void dump()/* __attribute__((used)) __attribute__((noinline))*/ {
    final raw_ostream /*&*/ OS = llvm.errs();
    
    OS.$out(/*KEEP_STR*/"<MCSection");
    OS.$out(/*KEEP_STR*/" Fragments:[\n      ");
    for (ilist_iterator<MCFragment> it = begin(), ie = end(); it.$noteq(ie); it.$preInc()) {
      if (it.$noteq(begin())) {
        OS.$out(/*KEEP_STR*/",\n      ");
      }
      it.$arrow().dump();
    }
    OS.$out(/*KEEP_STR*/"]>");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSection::PrintSwitchToSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", line = 188,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", old_line = 189,
   FQN="llvm::MCSection::PrintSwitchToSection", NM="_ZNK4llvm9MCSection20PrintSwitchToSectionERKNS_9MCAsmInfoERNS_11raw_ostreamEPKNS_6MCExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZNK4llvm9MCSection20PrintSwitchToSectionERKNS_9MCAsmInfoERNS_11raw_ostreamEPKNS_6MCExprE")
  //</editor-fold>
  public abstract /*virtual*/ void PrintSwitchToSection(final /*const*/ MCAsmInfo /*&*/ MAI, final raw_ostream /*&*/ OS, 
                      /*const*/ MCExpr /*P*/ Subsection) /*const*//* = 0*/;

  
  /// Return true if a .align directive should use "optimized nops" to fill
  /// instead of 0s.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSection::UseCodeAlign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", line = 193,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", old_line = 194,
   FQN="llvm::MCSection::UseCodeAlign", NM="_ZNK4llvm9MCSection12UseCodeAlignEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZNK4llvm9MCSection12UseCodeAlignEv")
  //</editor-fold>
  public abstract /*virtual*/ boolean UseCodeAlign() /*const*//* = 0*/;

  
  /// Check whether this section is "virtual", that is has no actual object
  /// file contents.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSection::isVirtualSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", line = 197,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSection.h", old_line = 198,
   FQN="llvm::MCSection::isVirtualSection", NM="_ZNK4llvm9MCSection16isVirtualSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp -nm=_ZNK4llvm9MCSection16isVirtualSectionEv")
  //</editor-fold>
  public abstract /*virtual*/ boolean isVirtualSection() /*const*//* = 0*/;

  @Override
  public Iterator<MCFragment> iterator() {
    return new JavaIterator<MCFragment>(begin(), end());
  }

  
  @Override public String toString() {
    return "" + "Begin=" + Begin // NOI18N
              + ", End=" + End // NOI18N
              + ", Alignment=" + Alignment // NOI18N
              + ", Ordinal=" + Ordinal // NOI18N
              + ", LayoutOrder=" + LayoutOrder // NOI18N
              + ", BundleLockState=" + BundleLockState // NOI18N
              + ", BundleLockNestingDepth=" + BundleLockNestingDepth // NOI18N
              + ", BundleGroupBeforeFirstInst=" + BundleGroupBeforeFirstInst // NOI18N
              + ", HasInstructions=" + HasInstructions // NOI18N
              + ", IsRegistered=" + IsRegistered // NOI18N
              + ", DummyFragment=" + DummyFragment // NOI18N
              + ", Fragments=" + Fragments // NOI18N
              + ", SubsectionFragmentMap=" + SubsectionFragmentMap // NOI18N
              + ", Variant=" + Variant // NOI18N
              + ", Kind=" + Kind; // NOI18N
  }
}
