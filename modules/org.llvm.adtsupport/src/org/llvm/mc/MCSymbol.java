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
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import static org.llvm.mc.impl.MCSymbolStatics.SentinelFragment;
import static org.llvm.support.AdtsupportLlvmGlobals.$out_raw_ostream_MCSymbol$C;


/// MCSymbol - Instances of this class represent a symbol name in the MC file,
/// and MCSymbols are created and uniqued by the MCContext class.  MCSymbols
/// should only be constructed with valid names for the object file.
///
/// If the symbol is defined/emitted into the current translation unit, the
/// Section member is set to indicate what section it lives in.  Otherwise, if
/// it is a reference to an external entity, it has a null section.
//<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 39,
 FQN="llvm::MCSymbol", NM="_ZN4llvm8MCSymbolE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZN4llvm8MCSymbolE")
//</editor-fold>
public class MCSymbol {

/*protected:*/
  /// The kind of the symbol.  If it is any value other than unset then this
  /// class is actually one of the appropriate subclasses of MCSymbol.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::SymbolKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 43,
   FQN="llvm::MCSymbol::SymbolKind", NM="_ZN4llvm8MCSymbol10SymbolKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZN4llvm8MCSymbol10SymbolKindE")
  //</editor-fold>
  protected enum SymbolKind implements Native.NativeUIntEnum {
    SymbolKindUnset(0),
    SymbolKindCOFF(SymbolKindUnset.getValue() + 1),
    SymbolKindELF(SymbolKindCOFF.getValue() + 1),
    SymbolKindMachO(SymbolKindELF.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static SymbolKind valueOf(int val) {
      SymbolKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final SymbolKind[] VALUES;
      private static final SymbolKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (SymbolKind kind : SymbolKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new SymbolKind[min < 0 ? (1-min) : 0];
        VALUES = new SymbolKind[max >= 0 ? (1+max) : 0];
        for (SymbolKind kind : SymbolKind.values()) {
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
    private SymbolKind(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  /// A symbol can contain an Offset, or Value, or be Common, but never more
  /// than one of these.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::Contents">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 52,
   FQN="llvm::MCSymbol::Contents", NM="_ZN4llvm8MCSymbol8ContentsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZN4llvm8MCSymbol8ContentsE")
  //</editor-fold>
  protected enum Contents/* : uint8_t*/ implements Native.NativeUCharEnum {
    SymContentsUnset(0),
    SymContentsOffset(SymContentsUnset.getValue() + 1),
    SymContentsVariable(SymContentsOffset.getValue() + 1),
    SymContentsCommon(SymContentsVariable.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Contents valueOf(byte/*uint8_t*/ val) {
      Contents out = valueOf((int)val);
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]. Int not capable to keep values?";
      return out;
    }
    public static Contents valueOf(int val) {
      Contents out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Contents[] VALUES;
      private static final Contents[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Contents kind : Contents.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Contents[min < 0 ? (1-min) : 0];
        VALUES = new Contents[max >= 0 ? (1+max) : 0];
        for (Contents kind : Contents.values()) {
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
    private Contents(int val) { this.value = (byte/*uint8_t*/)val;}
    @Override public final byte/*uint8_t*/ getValue() { return value;}
    //</editor-fold>
  };
  
  // Special sentinal value for the absolute pseudo fragment.
  
  // Sentinel value for the absolute pseudo fragment.
  protected static MCFragment /*P*/ AbsolutePseudoFragment = $AddrOf(SentinelFragment);
  
  /// If a symbol has a Fragment, the section is implied, so we only need
  /// one pointer.
  /// The special AbsolutePseudoFragment value is for absolute symbols.
  /// If this is a variable symbol, this caches the variable value's fragment.
  /// FIXME: We might be able to simplify this by having the asm streamer create
  /// dummy fragments.
  /// If this is a section, then it gives the symbol is defined in. This is null
  /// for undefined symbols.
  ///
  /// If this is a fragment, then it gives the fragment this symbol's value is
  /// relative to, if any.
  ///
  /// For the 'HasName' integer, this is true if this symbol is named.
  /// A named symbol will have a pointer to the name allocated in the bytes
  /// immediately prior to the MCSymbol.
  protected /*mutable */PointerIntPair<MCFragment /*P*/ > FragmentAndHasName;
  
  /// IsTemporary - True if this is an assembler temporary label, which
  /// typically does not survive in the .o file's symbol table.  Usually
  /// "Lfoo" or ".foo".
  protected /*JBIT unsigned int*/ boolean IsTemporary /*: 1*/;
  
  /// \brief True if this symbol can be redefined.
  protected /*JBIT unsigned int*/ boolean IsRedefinable /*: 1*/;
  
  /// IsUsed - True if this symbol has been used.
  protected /*mutable *//*JBIT unsigned int*/ boolean IsUsed /*: 1*/;
  
  protected /*mutable *//*JBIT unsigned int*/ boolean IsRegistered /*: 1*/;
  
  /// This symbol is visible outside this translation unit.
  protected /*mutable *//*JBIT unsigned int*/ boolean IsExternal /*: 1*/;
  
  /// This symbol is private extern.
  protected /*mutable *//*JBIT unsigned int*/ boolean IsPrivateExtern /*: 1*/;
  
  /// LLVM RTTI discriminator. This is actually a SymbolKind enumerator, but is
  /// unsigned to avoid sign extension and achieve better bitpacking with MSVC.
  protected /*JBYTE unsigned int*/ byte Kind /*: 2*/;
  
  /// True if we have created a relocation that uses this symbol.
  protected /*mutable *//*JBIT unsigned int*/ boolean IsUsedInReloc /*: 1*/;
  
  /// This is actually a Contents enumerator, but is unsigned to avoid sign
  /// extension and achieve better bitpacking with MSVC.
  protected /*JBYTE unsigned int*/ byte SymbolContents /*: 2*/;
  
  /// The alignment of the symbol, if it is 'common', or -1.
  ///
  /// The alignment is stored as log2(align) + 1.  This allows all values from
  /// 0 to 2^31 to be stored which is every power of 2 representable by an
  /// unsigned.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 114,
   FQN="llvm::MCSymbol::(anonymous)", NM="_ZN4llvm8MCSymbolE_Unnamed_enum2",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZN4llvm8MCSymbolE_Unnamed_enum2")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS : unsigned int {*/
    public static final /*uint*/int NumCommonAlignmentBits = 5;
  /*}*/;
  protected /*JBYTE unsigned int*/ byte CommonAlignLog2 /*: NumCommonAlignmentBits*/;
  
  /// The Flags field is used by object file implementations to store
  /// additional per symbol information which is not easily classified.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 119,
   FQN="llvm::MCSymbol::(anonymous)", NM="_ZN4llvm8MCSymbolE_Unnamed_enum3",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZN4llvm8MCSymbolE_Unnamed_enum3")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS : unsigned int {*/
    public static final /*uint*/int NumFlagsBits = 16;
  /*}*/;
  protected /*mutable *//*JCHAR uint32_t*/ char Flags /*: NumFlagsBits*/;
  
  /// Index field, for use by the object file implementation.
  protected /*mutable *//*uint32_t*/int Index/* = 0*/;
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 125,
   FQN="llvm::MCSymbol::(anonymous)", NM="_ZN4llvm8MCSymbolE_Unnamed_union1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZN4llvm8MCSymbolE_Unnamed_union1")
  //</editor-fold>
  protected static class/*union*/ Unnamed_union1 {
    /// The offset to apply to the fragment address to form this symbol's value.
    public long/*uint64_t*/ Offset;
    
    /// The size of the symbol, if it is 'common'.
    public long/*uint64_t*/ CommonSize;
    
    /// If non-null, the value for a variable symbol.
    public /*const*/ MCExpr /*P*/ Value;
    
    @Override public String toString() {
      return "" + "Offset=" + Offset // NOI18N
                + ", CommonSize=" + CommonSize // NOI18N
                + ", Value=" + "[MCExpr]"; // NOI18N
    }
  };
  protected Unnamed_union1 Unnamed_field13 = new Unnamed_union1();
/*protected:*/
  // MCContext creates and uniques these.
  /*friend  class MCExpr*/
  /*friend  class MCContext*/
  
  /// \brief The name for a symbol.
  /// MCSymbol contains a uint64_t so is probably aligned to 8.  On a 32-bit
  /// system, the name is a pointer so isn't going to satisfy the 8 byte
  /// alignment of uint64_t.  Account for that here.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 144,
   FQN="llvm::MCSymbol::(anonymous)", NM="_NameEntryStorageTy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_NameEntryStorageTy")
  //</editor-fold>
  protected static class/*union*/ NameEntryStorageTy {
    public /*const*/StringMapEntryBool/*P*/ NameEntry;
    public long/*uint64_t*/ AlignmentPadding;
    
    private static int $sizeof_NameEntryStorageTy() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override public String toString() {
      return "" + "NameEntry=" + NameEntry // NOI18N
                + ", AlignmentPadding=" + AlignmentPadding; // NOI18N
    }
  };
  // JAVA: typedef union NameEntryStorageTy NameEntryStorageTy
//  public final class NameEntryStorageTy extends  NameEntryStorageTy{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::MCSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 149,
   FQN="llvm::MCSymbol::MCSymbol", NM="_ZN4llvm8MCSymbolC1ENS0_10SymbolKindEPKNS_14StringMapEntryIbEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZN4llvm8MCSymbolC1ENS0_10SymbolKindEPKNS_14StringMapEntryIbEEb")
  //</editor-fold>
  protected MCSymbol(SymbolKind Kind, /*const*/StringMapEntryBool/*P*/ Name, boolean isTemporary) {
    // : FragmentAndHasName(), IsTemporary(isTemporary), IsRedefinable(false), IsUsed(false), IsRegistered(false), IsExternal(false), IsPrivateExtern(false), Kind(Kind), IsUsedInReloc(false), SymbolContents(SymContentsUnset), CommonAlignLog2(0), Flags(0), Index(0) 
    //START JInit
    this.FragmentAndHasName = new PointerIntPair<MCFragment /*P*/ >();
    this.IsTemporary = isTemporary;
    this.IsRedefinable = false;
    this.IsUsed = false;
    this.IsRegistered = false;
    this.IsExternal = false;
    this.IsPrivateExtern = false;
    this.Kind = $uint2uint_2bits(Kind.getValue());
    this.IsUsedInReloc = false;
    this.SymbolContents = $uint2uint_2bits(Contents.SymContentsUnset.getValue());
    this.CommonAlignLog2 = $uint2uint_5bits(0);
    this.Flags = $uint2uint_16bits(0);
    /*InClass*/this.Index = 0;
    //END JInit
    Unnamed_field13.Offset = $int2ulong(0);
    FragmentAndHasName.setInt(((!!(Name != null)) ? 1 : 0));
    if ((Name != null)) {
      getNameEntryPtr().$set(Name);
    }
  }

  
  // Provide custom new/delete as we will only allocate space for a name
  // if we need one.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::operator new">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp", line = 25,
   FQN="llvm::MCSymbol::operator new", NM="_ZN4llvm8MCSymbolnwEjPKNS_14StringMapEntryIbEERNS_9MCContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZN4llvm8MCSymbolnwEjPKNS_14StringMapEntryIbEERNS_9MCContextE")
  //</editor-fold>
  protected static Object/*void P*/ $new(/*size_t*/int s, /*const*/StringMapEntryBool/*P*/ Name, 
      final MCContext /*&*/ Ctx) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::operator delete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 167,
   FQN="llvm::MCSymbol::operator delete", NM="_ZN4llvm8MCSymboldlEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZN4llvm8MCSymboldlEPv")
  //</editor-fold>
  private static void $delete(Object/*void P*/ $Prm0) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  /// \brief Placement delete - required by std, but never called.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::operator delete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 169,
   FQN="llvm::MCSymbol::operator delete", NM="_ZN4llvm8MCSymboldlEPvj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZN4llvm8MCSymboldlEPvj")
  //</editor-fold>
  private static void $delete(Object/*void P*/ $Prm0, /*uint*/int $Prm1) {
    throw new llvm_unreachable("Constructor throws?");
  }

  /// \brief Placement delete - required by std, but never called.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::operator delete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 173,
   FQN="llvm::MCSymbol::operator delete", NM="_ZN4llvm8MCSymboldlEPvjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZN4llvm8MCSymboldlEPvjb")
  //</editor-fold>
  private static void $delete(Object/*void P*/ $Prm0, /*uint*/int $Prm1, boolean $Prm2) {
    throw new llvm_unreachable("Constructor throws?");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::MCSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 177,
   FQN="llvm::MCSymbol::MCSymbol", NM="_ZN4llvm8MCSymbolC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZN4llvm8MCSymbolC1ERKS0_")
  //</editor-fold>
  protected/*private*/ MCSymbol(final /*const*/ MCSymbol /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 178,
   FQN="llvm::MCSymbol::operator=", NM="_ZN4llvm8MCSymbolaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZN4llvm8MCSymbolaSERKS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ MCSymbol /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::getSectionPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 179,
   FQN="llvm::MCSymbol::getSectionPtr", NM="_ZNK4llvm8MCSymbol13getSectionPtrEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZNK4llvm8MCSymbol13getSectionPtrEb")
  //</editor-fold>
  private MCSection /*P*/ getSectionPtr() /*const*/ {
    return getSectionPtr(true);
  }
  private MCSection /*P*/ getSectionPtr(boolean SetUsed/*= true*/) /*const*/ {
    {
      MCFragment /*P*/ F = getFragment(SetUsed);
      if ((F != null)) {
        assert (F != AbsolutePseudoFragment);
        return F.getParent();
      }
    }
    return null;
  }

  
  /// \brief Get a reference to the name field.  Requires that we have a name
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::getNameEntryPtr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 188,
   FQN="llvm::MCSymbol::getNameEntryPtr", NM="_ZN4llvm8MCSymbol15getNameEntryPtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZN4llvm8MCSymbol15getNameEntryPtrEv")
  //</editor-fold>
  private /*const*/type$ref<StringMapEntryBool/*P*/ /*&*/> getNameEntryPtr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::getNameEntryPtr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 193,
   FQN="llvm::MCSymbol::getNameEntryPtr", NM="_ZNK4llvm8MCSymbol15getNameEntryPtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZNK4llvm8MCSymbol15getNameEntryPtrEv")
  //</editor-fold>
  private /*const*/type$ref<StringMapEntryBool/*P*/ /*&*/> getNameEntryPtr$Const() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*public:*/
  /// getName - Get the symbol name.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 199,
   FQN="llvm::MCSymbol::getName", NM="_ZNK4llvm8MCSymbol7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZNK4llvm8MCSymbol7getNameEv")
  //</editor-fold>
  public StringRef getName() /*const*/ {
    if (!(FragmentAndHasName.getInt() != 0)) {
      return new StringRef();
    }
    
    return getNameEntryPtr$Const().$deref().first();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::isRegistered">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 206,
   FQN="llvm::MCSymbol::isRegistered", NM="_ZNK4llvm8MCSymbol12isRegisteredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZNK4llvm8MCSymbol12isRegisteredEv")
  //</editor-fold>
  public boolean isRegistered() /*const*/ {
    return IsRegistered;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::setIsRegistered">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 207,
   FQN="llvm::MCSymbol::setIsRegistered", NM="_ZNK4llvm8MCSymbol15setIsRegisteredEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZNK4llvm8MCSymbol15setIsRegisteredEb")
  //</editor-fold>
  public void setIsRegistered(boolean Value) /*const*/ {
    IsRegistered = Value;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::setUsedInReloc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 209,
   FQN="llvm::MCSymbol::setUsedInReloc", NM="_ZNK4llvm8MCSymbol14setUsedInRelocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZNK4llvm8MCSymbol14setUsedInRelocEv")
  //</editor-fold>
  public void setUsedInReloc() /*const*/ {
    IsUsedInReloc = true;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::isUsedInReloc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 210,
   FQN="llvm::MCSymbol::isUsedInReloc", NM="_ZNK4llvm8MCSymbol13isUsedInRelocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZNK4llvm8MCSymbol13isUsedInRelocEv")
  //</editor-fold>
  public boolean isUsedInReloc() /*const*/ {
    return IsUsedInReloc;
  }

  
  /// \name Accessors
  /// @{
  
  /// isTemporary - Check if this is an assembler temporary symbol.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::isTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 216,
   FQN="llvm::MCSymbol::isTemporary", NM="_ZNK4llvm8MCSymbol11isTemporaryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZNK4llvm8MCSymbol11isTemporaryEv")
  //</editor-fold>
  public boolean isTemporary() /*const*/ {
    return IsTemporary;
  }

  
  /// isUsed - Check if this is used.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::isUsed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 219,
   FQN="llvm::MCSymbol::isUsed", NM="_ZNK4llvm8MCSymbol6isUsedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZNK4llvm8MCSymbol6isUsedEv")
  //</editor-fold>
  public boolean isUsed() /*const*/ {
    return IsUsed;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::setUsed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 220,
   FQN="llvm::MCSymbol::setUsed", NM="_ZNK4llvm8MCSymbol7setUsedEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZNK4llvm8MCSymbol7setUsedEb")
  //</editor-fold>
  public void setUsed(boolean Value) /*const*/ {
    IsUsed |= Value;
  }

  
  /// \brief Check if this symbol is redefinable.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::isRedefinable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 223,
   FQN="llvm::MCSymbol::isRedefinable", NM="_ZNK4llvm8MCSymbol13isRedefinableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZNK4llvm8MCSymbol13isRedefinableEv")
  //</editor-fold>
  public boolean isRedefinable() /*const*/ {
    return IsRedefinable;
  }

  /// \brief Mark this symbol as redefinable.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::setRedefinable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 225,
   FQN="llvm::MCSymbol::setRedefinable", NM="_ZN4llvm8MCSymbol14setRedefinableEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZN4llvm8MCSymbol14setRedefinableEb")
  //</editor-fold>
  public void setRedefinable(boolean Value) {
    IsRedefinable = Value;
  }

  /// \brief Prepare this symbol to be redefined.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::redefineIfPossible">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 227,
   FQN="llvm::MCSymbol::redefineIfPossible", NM="_ZN4llvm8MCSymbol18redefineIfPossibleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZN4llvm8MCSymbol18redefineIfPossibleEv")
  //</editor-fold>
  public void redefineIfPossible() {
    if (IsRedefinable) {
      if ($2bits_uint2uint(SymbolContents) == Contents.SymContentsVariable.getValue()) {
        Unnamed_field13.Value = null;
        SymbolContents = $uint2uint_2bits(Contents.SymContentsUnset.getValue());
      }
      setUndefined();
      IsRedefinable = false;
    }
  }

  
  /// @}
  /// \name Associated Sections
  /// @{
  
  /// isDefined - Check if this symbol is defined (i.e., it has an address).
  ///
  /// Defined symbols are either absolute or in some section.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::isDefined">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 245,
   FQN="llvm::MCSymbol::isDefined", NM="_ZNK4llvm8MCSymbol9isDefinedEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZNK4llvm8MCSymbol9isDefinedEb")
  //</editor-fold>
  public boolean isDefined() /*const*/ {
    return isDefined(true);
  }
  public boolean isDefined(boolean SetUsed/*= true*/) /*const*/ {
    return getFragment(SetUsed) != null;
  }

  
  /// isInSection - Check if this symbol is defined in some section (i.e., it
  /// is defined but not absolute).
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::isInSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 251,
   FQN="llvm::MCSymbol::isInSection", NM="_ZNK4llvm8MCSymbol11isInSectionEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZNK4llvm8MCSymbol11isInSectionEb")
  //</editor-fold>
  public boolean isInSection() /*const*/ {
    return isInSection(true);
  }
  public boolean isInSection(boolean SetUsed/*= true*/) /*const*/ {
    return isDefined(SetUsed) && !isAbsolute(SetUsed);
  }

  
  /// isUndefined - Check if this symbol undefined (i.e., implicitly defined).
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::isUndefined">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 256,
   FQN="llvm::MCSymbol::isUndefined", NM="_ZNK4llvm8MCSymbol11isUndefinedEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZNK4llvm8MCSymbol11isUndefinedEb")
  //</editor-fold>
  public boolean isUndefined() /*const*/ {
    return isUndefined(true);
  }
  public boolean isUndefined(boolean SetUsed/*= true*/) /*const*/ {
    return !isDefined(SetUsed);
  }

  
  /// isAbsolute - Check if this is an absolute symbol.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::isAbsolute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 259,
   FQN="llvm::MCSymbol::isAbsolute", NM="_ZNK4llvm8MCSymbol10isAbsoluteEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZNK4llvm8MCSymbol10isAbsoluteEb")
  //</editor-fold>
  public boolean isAbsolute() /*const*/ {
    return isAbsolute(true);
  }
  public boolean isAbsolute(boolean SetUsed/*= true*/) /*const*/ {
    return getFragment(SetUsed) == AbsolutePseudoFragment;
  }

  
  /// Get the section associated with a defined, non-absolute symbol.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::getSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 264,
   FQN="llvm::MCSymbol::getSection", NM="_ZNK4llvm8MCSymbol10getSectionEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZNK4llvm8MCSymbol10getSectionEb")
  //</editor-fold>
  public MCSection /*&*/ getSection() /*const*/ {
    return getSection(true);
  }
  public MCSection /*&*/ getSection(boolean SetUsed/*= true*/) /*const*/ {
    assert (isInSection(SetUsed)) : "Invalid accessor!";
    return $Deref(getSectionPtr(SetUsed));
  }

  
  /// Mark the symbol as defined in the fragment \p F.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::setFragment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 270,
   FQN="llvm::MCSymbol::setFragment", NM="_ZNK4llvm8MCSymbol11setFragmentEPNS_10MCFragmentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZNK4llvm8MCSymbol11setFragmentEPNS_10MCFragmentE")
  //</editor-fold>
  public void setFragment(MCFragment /*P*/ F) /*const*/ {
    assert (!isVariable()) : "Cannot set fragment of variable";
    FragmentAndHasName.setPointer(F);
  }

  
  /// Mark the symbol as undefined.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::setUndefined">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 276,
   FQN="llvm::MCSymbol::setUndefined", NM="_ZN4llvm8MCSymbol12setUndefinedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZN4llvm8MCSymbol12setUndefinedEv")
  //</editor-fold>
  public void setUndefined() {
    FragmentAndHasName.setPointer((MCFragment /*P*/ )null);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::isELF">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 278,
   FQN="llvm::MCSymbol::isELF", NM="_ZNK4llvm8MCSymbol5isELFEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZNK4llvm8MCSymbol5isELFEv")
  //</editor-fold>
  public boolean isELF() /*const*/ {
    return $2bits_uint2uint(Kind) == SymbolKind.SymbolKindELF.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::isCOFF">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 280,
   FQN="llvm::MCSymbol::isCOFF", NM="_ZNK4llvm8MCSymbol6isCOFFEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZNK4llvm8MCSymbol6isCOFFEv")
  //</editor-fold>
  public boolean isCOFF() /*const*/ {
    return $2bits_uint2uint(Kind) == SymbolKind.SymbolKindCOFF.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::isMachO">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 282,
   FQN="llvm::MCSymbol::isMachO", NM="_ZNK4llvm8MCSymbol7isMachOEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZNK4llvm8MCSymbol7isMachOEv")
  //</editor-fold>
  public boolean isMachO() /*const*/ {
    return $2bits_uint2uint(Kind) == SymbolKind.SymbolKindMachO.getValue();
  }

  
  /// @}
  /// \name Variable Symbols
  /// @{
  
  /// isVariable - Check if this is a variable symbol.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::isVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 289,
   FQN="llvm::MCSymbol::isVariable", NM="_ZNK4llvm8MCSymbol10isVariableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZNK4llvm8MCSymbol10isVariableEv")
  //</editor-fold>
  public boolean isVariable() /*const*/ {
    return $2bits_uint2uint(SymbolContents) == Contents.SymContentsVariable.getValue();
  }

  
  /// getVariableValue - Get the value for variable symbols.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::getVariableValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 294,
   FQN="llvm::MCSymbol::getVariableValue", NM="_ZNK4llvm8MCSymbol16getVariableValueEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZNK4llvm8MCSymbol16getVariableValueEb")
  //</editor-fold>
  public /*const*/ MCExpr /*P*/ getVariableValue() /*const*/ {
    return getVariableValue(true);
  }
  public /*const*/ MCExpr /*P*/ getVariableValue(boolean SetUsed/*= true*/) /*const*/ {
    assert (isVariable()) : "Invalid accessor!";
    IsUsed |= SetUsed;
    return Unnamed_field13.Value;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::setVariableValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp", line = 43,
   FQN="llvm::MCSymbol::setVariableValue", NM="_ZN4llvm8MCSymbol16setVariableValueEPKNS_6MCExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZN4llvm8MCSymbol16setVariableValueEPKNS_6MCExprE")
  //</editor-fold>
  public void setVariableValue(/*const*/ MCExpr /*P*/ Value) {
    assert (!IsUsed) : "Cannot set a variable that has already been used.";
    assert ((Value != null)) : "Invalid variable value!";
    assert (($2bits_uint2uint(SymbolContents) == Contents.SymContentsUnset.getValue() || $2bits_uint2uint(SymbolContents) == Contents.SymContentsVariable.getValue())) : "Cannot give common/offset symbol a variable value";
    this.Unnamed_field13.Value = Value;
    SymbolContents = $uint2uint_2bits(Contents.SymContentsVariable.getValue());
    setUndefined();
  }

  
  /// @}
  
  /// Get the (implementation defined) index.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::getIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 305,
   FQN="llvm::MCSymbol::getIndex", NM="_ZNK4llvm8MCSymbol8getIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZNK4llvm8MCSymbol8getIndexEv")
  //</editor-fold>
  public /*uint32_t*/int getIndex() /*const*/ {
    return Index;
  }

  
  /// Set the (implementation defined) index.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::setIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 310,
   FQN="llvm::MCSymbol::setIndex", NM="_ZNK4llvm8MCSymbol8setIndexEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZNK4llvm8MCSymbol8setIndexEj")
  //</editor-fold>
  public void setIndex(/*uint32_t*/int Value) /*const*/ {
    Index = Value;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::getOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 314,
   FQN="llvm::MCSymbol::getOffset", NM="_ZNK4llvm8MCSymbol9getOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZNK4llvm8MCSymbol9getOffsetEv")
  //</editor-fold>
  public long/*uint64_t*/ getOffset() /*const*/ {
    assert (($2bits_uint2uint(SymbolContents) == Contents.SymContentsUnset.getValue() || $2bits_uint2uint(SymbolContents) == Contents.SymContentsOffset.getValue())) : "Cannot get offset for a common/variable symbol";
    return Unnamed_field13.Offset;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::setOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 320,
   FQN="llvm::MCSymbol::setOffset", NM="_ZN4llvm8MCSymbol9setOffsetEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZN4llvm8MCSymbol9setOffsetEy")
  //</editor-fold>
  public void setOffset(long/*uint64_t*/ Value) {
    assert (($2bits_uint2uint(SymbolContents) == Contents.SymContentsUnset.getValue() || $2bits_uint2uint(SymbolContents) == Contents.SymContentsOffset.getValue())) : "Cannot set offset for a common/variable symbol";
    Unnamed_field13.Offset = Value;
    SymbolContents = $uint2uint_2bits(Contents.SymContentsOffset.getValue());
  }

  
  /// Return the size of a 'common' symbol.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::getCommonSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 329,
   FQN="llvm::MCSymbol::getCommonSize", NM="_ZNK4llvm8MCSymbol13getCommonSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZNK4llvm8MCSymbol13getCommonSizeEv")
  //</editor-fold>
  public long/*uint64_t*/ getCommonSize() /*const*/ {
    assert (isCommon()) : "Not a 'common' symbol!";
    return Unnamed_field13.CommonSize;
  }

  
  /// Mark this symbol as being 'common'.
  ///
  /// \param Size - The size of the symbol.
  /// \param Align - The alignment of the symbol.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::setCommon">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 338,
   FQN="llvm::MCSymbol::setCommon", NM="_ZN4llvm8MCSymbol9setCommonEyj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZN4llvm8MCSymbol9setCommonEyj")
  //</editor-fold>
  public void setCommon(long/*uint64_t*/ Size, /*uint*/int Align) {
    assert (getOffset() == $int2ullong(0));
    Unnamed_field13.CommonSize = Size;
    SymbolContents = $uint2uint_2bits(Contents.SymContentsCommon.getValue());
    assert ((!(Align != 0) || isPowerOf2_32(Align))) : "Alignment must be a power of 2";
    /*uint*/int Log2Align = Log2_32(Align) + 1;
    assert ($less_uint(Log2Align, (1/*U*/ << NumCommonAlignmentBits))) : "Out of range alignment";
    CommonAlignLog2 = $uint2uint_5bits(Log2Align);
  }

  
  ///  Return the alignment of a 'common' symbol.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::getCommonAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 352,
   FQN="llvm::MCSymbol::getCommonAlignment", NM="_ZNK4llvm8MCSymbol18getCommonAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZNK4llvm8MCSymbol18getCommonAlignmentEv")
  //</editor-fold>
  public /*uint*/int getCommonAlignment() /*const*/ {
    assert (isCommon()) : "Not a 'common' symbol!";
    return ($5bits_uint2uint(CommonAlignLog2) != 0) ? (1/*U*/ << ($5bits_uint2uint(CommonAlignLog2) - 1)) : 0;
  }

  
  /// Declare this symbol as being 'common'.
  ///
  /// \param Size - The size of the symbol.
  /// \param Align - The alignment of the symbol.
  /// \return True if symbol was already declared as a different type
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::declareCommon">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 362,
   FQN="llvm::MCSymbol::declareCommon", NM="_ZN4llvm8MCSymbol13declareCommonEyj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZN4llvm8MCSymbol13declareCommonEyj")
  //</editor-fold>
  public boolean declareCommon(long/*uint64_t*/ Size, /*uint*/int Align) {
    assert (isCommon() || getOffset() == $int2ullong(0));
    if (isCommon()) {
      if (Unnamed_field13.CommonSize != Size || getCommonAlignment() != Align) {
        return true;
      }
    } else {
      setCommon(Size, Align);
    }
    return false;
  }

  
  /// Is this a 'common' symbol.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::isCommon">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 373,
   FQN="llvm::MCSymbol::isCommon", NM="_ZNK4llvm8MCSymbol8isCommonEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZNK4llvm8MCSymbol8isCommonEv")
  //</editor-fold>
  public boolean isCommon() /*const*/ {
    return $2bits_uint2uint(SymbolContents) == Contents.SymContentsCommon.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::getFragment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 377,
   FQN="llvm::MCSymbol::getFragment", NM="_ZNK4llvm8MCSymbol11getFragmentEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZNK4llvm8MCSymbol11getFragmentEb")
  //</editor-fold>
  public MCFragment /*P*/ getFragment() /*const*/ {
    return getFragment(true);
  }
  public MCFragment /*P*/ getFragment(boolean SetUsed/*= true*/) /*const*/ {
    MCFragment /*P*/ Fragment = FragmentAndHasName.getPointer();
    if ((Fragment != null) || !isVariable()) {
      return Fragment;
    }
    Fragment = getVariableValue(SetUsed).findAssociatedFragment();
    FragmentAndHasName.setPointer(Fragment);
    return Fragment;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::isExternal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 386,
   FQN="llvm::MCSymbol::isExternal", NM="_ZNK4llvm8MCSymbol10isExternalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZNK4llvm8MCSymbol10isExternalEv")
  //</editor-fold>
  public boolean isExternal() /*const*/ {
    return IsExternal;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::setExternal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 387,
   FQN="llvm::MCSymbol::setExternal", NM="_ZNK4llvm8MCSymbol11setExternalEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZNK4llvm8MCSymbol11setExternalEb")
  //</editor-fold>
  public void setExternal(boolean Value) /*const*/ {
    IsExternal = Value;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::isPrivateExtern">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 389,
   FQN="llvm::MCSymbol::isPrivateExtern", NM="_ZNK4llvm8MCSymbol15isPrivateExternEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZNK4llvm8MCSymbol15isPrivateExternEv")
  //</editor-fold>
  public boolean isPrivateExtern() /*const*/ {
    return IsPrivateExtern;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::setPrivateExtern">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 390,
   FQN="llvm::MCSymbol::setPrivateExtern", NM="_ZN4llvm8MCSymbol16setPrivateExternEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZN4llvm8MCSymbol16setPrivateExternEb")
  //</editor-fold>
  public void setPrivateExtern(boolean Value) {
    IsPrivateExtern = Value;
  }

  
  /// print - Print the value to the stream \p OS.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp", line = 54,
   FQN="llvm::MCSymbol::print", NM="_ZNK4llvm8MCSymbol5printERNS_11raw_ostreamEPKNS_9MCAsmInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZNK4llvm8MCSymbol5printERNS_11raw_ostreamEPKNS_9MCAsmInfoE")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS, /*const*/ MCAsmInfo /*P*/ MAI) /*const*/ {
    // The name for this MCSymbol is required to be a valid target name.  However,
    // some targets support quoting names with funny characters.  If the name
    // contains a funny character, then print it quoted.
    StringRef Name = getName();
    if (!(MAI != null) || MAI.isValidUnquotedName(new StringRef(Name))) {
      OS.$out(/*NO_COPY*/Name);
      return;
    }
    if ((MAI != null) && !MAI.supportsNameQuoting()) {
      report_fatal_error($("Symbol name with unsupported characters"));
    }
    
    OS.$out_char($$DBL_QUOTE);
    for (/*char*/byte C : Name.data().$array()) {
      if (C == $$LF) {
        OS.$out(/*KEEP_STR*/"\\n");
      } else if (C == $$DBL_QUOTE) {
        OS.$out(/*KEEP_STR*/"\\\"");
      } else {
        OS.$out_char(C);
      }
    }
    OS.$out_char($$DBL_QUOTE);
  }

  
  /// dump - Print the value to stderr.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp", line = 80,
   FQN="llvm::MCSymbol::dump", NM="_ZNK4llvm8MCSymbol4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZNK4llvm8MCSymbol4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    $out_raw_ostream_MCSymbol$C(dbgs(), /*Deref*/this);
  }

/*protected:*/
  /// Get the (implementation defined) symbol flags.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::getFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 400,
   FQN="llvm::MCSymbol::getFlags", NM="_ZNK4llvm8MCSymbol8getFlagsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZNK4llvm8MCSymbol8getFlagsEv")
  //</editor-fold>
  protected /*uint32_t*/int getFlags() /*const*/ {
    return $16bits_uint2uint(Flags);
  }

  
  /// Set the (implementation defined) symbol flags.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::setFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 403,
   FQN="llvm::MCSymbol::setFlags", NM="_ZNK4llvm8MCSymbol8setFlagsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZNK4llvm8MCSymbol8setFlagsEj")
  //</editor-fold>
  protected void setFlags(/*uint32_t*/int Value) /*const*/ {
    assert ($less_uint(Value, (1/*U*/ << NumFlagsBits))) : "Out of range flags";
    Flags = $uint2uint_16bits(Value);
  }

  
  /// Modify the flags via a mask
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbol::modifyFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 409,
   FQN="llvm::MCSymbol::modifyFlags", NM="_ZNK4llvm8MCSymbol11modifyFlagsEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp -nm=_ZNK4llvm8MCSymbol11modifyFlagsEjj")
  //</editor-fold>
  protected void modifyFlags(/*uint32_t*/int Value, /*uint32_t*/int Mask) /*const*/ {
    assert ($less_uint(Value, (1/*U*/ << NumFlagsBits))) : "Out of range flags";
    Flags = $uint2uint_16bits(($16bits_uint2uint(Flags) & ~Mask) | Value);
  }

  public static <T> T/*void P*/ $new(/*const*/StringMapEntryBool/*P*/ Name, final MCContext /*&*/ Ctx, New$ConstructorCallback<T/*P*/> New$Ctr) {
  return New$Ctr.$call((type$ptr<?>)null);
  }
  
  public MCSymbol() {
  }

  @Override public String toString() {
    return "" + "FragmentAndHasName=" + FragmentAndHasName // NOI18N
              + ", IsTemporary=" + IsTemporary // NOI18N
              + ", IsRedefinable=" + IsRedefinable // NOI18N
              + ", IsUsed=" + IsUsed // NOI18N
              + ", IsRegistered=" + IsRegistered // NOI18N
              + ", IsExternal=" + IsExternal // NOI18N
              + ", IsPrivateExtern=" + IsPrivateExtern // NOI18N
              + ", Kind=" + $uchar2uint(Kind) // NOI18N
              + ", IsUsedInReloc=" + IsUsedInReloc // NOI18N
              + ", SymbolContents=" + $uchar2uint(SymbolContents) // NOI18N
              + ", CommonAlignLog2=" + $uchar2uint(CommonAlignLog2) // NOI18N
              + ", Flags=" + $ushort2uint(Flags) // NOI18N
              + ", Index=" + Index // NOI18N
              + ", Unnamed_field13=" + Unnamed_field13; // NOI18N
  }
}
