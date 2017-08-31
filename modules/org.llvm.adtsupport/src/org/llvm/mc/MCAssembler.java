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
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import static org.llvm.adt.java.ADTRTTI.*;
import org.llvm.mc.impl.MCAssemblerStatics;
import org.llvm.mc.stats.impl.StatsStatics;
import static org.llvm.mc.stats.impl.StatsStatics.RelaxationSteps;
import static org.llvm.support.AdtsupportLlvmGlobals.*;

//<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 56,
 FQN="llvm::MCAssembler", NM="_ZN4llvm11MCAssemblerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAssemblerE")
//</editor-fold>
public class MCAssembler implements Destructors.ClassWithDestructor, Iterable<MCSection> {
  /*friend  class MCAsmLayout*/
/*public:*/
  // JAVA: typedef std::vector<MCSection *> SectionListType
//  public final class SectionListType extends std.vector<MCSection /*P*/ >{ };
  // JAVA: typedef std::vector<const MCSymbol *> SymbolDataListType
//  public final class SymbolDataListType extends std.vector</*const*/ MCSymbol /*P*/ >{ };
  
  // JAVA: typedef pointee_iterator<SectionListType::const_iterator> const_iterator
//  public final class const_iterator extends pointee_iterator<std.vector.iterator</*const*/ MCSection /*P*/ > >{ };
  // JAVA: typedef pointee_iterator<SectionListType::iterator> iterator
//  public final class iterator extends pointee_iterator<std.vector.iterator<MCSection /*P*/ > >{ };
  
  // JAVA: typedef pointee_iterator<SymbolDataListType::const_iterator> const_symbol_iterator
//  public final class const_symbol_iterator extends pointee_iterator<std.vector.iterator</*const*/ MCSymbol /*P*/ > >{ };
  // JAVA: typedef pointee_iterator<SymbolDataListType::iterator> symbol_iterator
//  public final class symbol_iterator extends pointee_iterator<std.vector.iterator</*const*/ MCSymbol /*P*/ > >{ };
  
  // JAVA: typedef iterator_range<symbol_iterator> symbol_range
//  public final class symbol_range extends iterator_range</*const*/ MCSymbol /*&*/ >{ };
  // JAVA: typedef iterator_range<const_symbol_iterator> const_symbol_range
//  public final class const_symbol_range extends iterator_range</*const*/ MCSymbol /*&*/ >{ };
  
  // JAVA: typedef std::vector<IndirectSymbolData>::const_iterator const_indirect_symbol_iterator
//  public final class const_indirect_symbol_iterator extends std.vector.iterator</*const*/ IndirectSymbolData /*P*/ >{ };
  // JAVA: typedef std::vector<IndirectSymbolData>::iterator indirect_symbol_iterator
//  public final class indirect_symbol_iterator extends std.vector.iterator<IndirectSymbolData /*P*/ >{ };
  
  // JAVA: typedef std::vector<DataRegionData>::const_iterator const_data_region_iterator
//  public final class const_data_region_iterator extends std.vector.iterator</*const*/ DataRegionData /*P*/ >{ };
  // JAVA: typedef std::vector<DataRegionData>::iterator data_region_iterator
//  public final class data_region_iterator extends std.vector.iterator<DataRegionData /*P*/ >{ };
  
  /// MachO specific deployment target version info.
  // A Major version of 0 indicates that no version information was supplied
  // and so the corresponding load command should not be emitted.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 84,
   FQN="llvm::MCAssembler::(anonymous)", NM="_VersionMinInfoType",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_VersionMinInfoType")
  //</editor-fold>
  public static class/*struct*/ VersionMinInfoType {
    public MCVersionMinType Kind;
    public /*uint*/int Major;
    public /*uint*/int Minor;
    public /*uint*/int Update;
    //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::(anonymous struct)::">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 84,
     FQN="llvm::MCAssembler::(anonymous struct)::", NM="_ZN4llvm11MCAssembler18VersionMinInfoTypeC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAssembler18VersionMinInfoTypeC1Ev")
    //</editor-fold>
    public /*inline*/ VersionMinInfoType() {
    }

    
    @Override public String toString() {
      return "" + "Kind=" + Kind // NOI18N
                + ", Major=" + Major // NOI18N
                + ", Minor=" + Minor // NOI18N
                + ", Update=" + Update; // NOI18N
    }
  };
  // JAVA: typedef struct VersionMinInfoType VersionMinInfoType
//  public final class VersionMinInfoType extends  VersionMinInfoType{ };
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::MCAssembler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 92,
   FQN="llvm::MCAssembler::MCAssembler", NM="_ZN4llvm11MCAssemblerC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAssemblerC1ERKS0_")
  //</editor-fold>
  protected/*private*/ MCAssembler(final /*const*/ MCAssembler /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 93,
   FQN="llvm::MCAssembler::operator=", NM="_ZN4llvm11MCAssembleraSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAssembleraSERKS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ MCAssembler /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
  private final MCContext /*&*/ Context;
  
  private final MCAsmBackend /*&*/ Backend;
  
  private final MCCodeEmitter /*&*/ Emitter;
  
  private final MCObjectWriter /*&*/ Writer;
  
  private std.vector<MCSection /*P*/ > Sections;
  
  private std.vector</*const*/ MCSymbol /*P*/ > Symbols;
  
  private std.vector<IndirectSymbolData> IndirectSymbols;
  
  private std.vector<DataRegionData> DataRegions;
  
  /// The list of linker options to propagate into the object file.
  private std.vector<std.vectorString> LinkerOptions;
  
  /// List of declared file names
  private std.vectorString FileNames;
  
  private MCDwarfLineTableParams LTParams;
  
  /// The set of function symbols for which a .thumb_func directive has
  /// been seen.
  //
  // FIXME: We really would like this in target specific code rather than
  // here. Maybe when the relocation stuff moves to target specific,
  // this can go with it? The streamer would need some target specific
  // refactoring too.
  private /*mutable */SmallPtrSet</*const*/ MCSymbol /*P*/ > ThumbFuncs;
  
  /// \brief The bundle alignment size currently set in the assembler.
  ///
  /// By default it's 0, which means bundling is disabled.
  private /*uint*/int BundleAlignSize;
  
  private /*JBIT unsigned int*/ boolean RelaxAll /*: 1*/;
  private /*JBIT unsigned int*/ boolean SubsectionsViaSymbols /*: 1*/;
  private /*JBIT unsigned int*/ boolean IncrementalLinkerCompatible /*: 1*/;
  
  /// ELF specific e_header flags
  // It would be good if there were an MCELFAssembler class to hold this.
  // ELF header flags are used both by the integrated and standalone assemblers.
  // Access to the flags is necessary in cases where assembler directives affect
  // which flags to be set.
  private /*uint*/int ELFHeaderEFlags;
  
  /// Used to communicate Linker Optimization Hint information between
  /// the Streamer and the .o writer
  private MCLOHContainer LOHContainer;
  
  private  VersionMinInfoType VersionMinInfo = new  VersionMinInfoType();
/*private:*/
  /// Evaluate a fixup to a relocatable expression and the value which should be
  /// placed into the fixup.
  ///
  /// \param Layout The layout to use for evaluation.
  /// \param Fixup The fixup to evaluate.
  /// \param DF The fragment the fixup is inside.
  /// \param Target [out] On return, the relocatable expression the fixup
  /// evaluates to.
  /// \param Value [out] On return, the value of the fixup as currently laid
  /// out.
  /// \return Whether the fixup value was fully resolved. This is true if the
  /// \p Value result is fixed, otherwise the value may change due to
  /// relocation.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::evaluateFixup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", line = 169,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", old_line = 168,
   FQN="llvm::MCAssembler::evaluateFixup", NM="_ZNK4llvm11MCAssembler13evaluateFixupERKNS_11MCAsmLayoutERKNS_7MCFixupEPKNS_10MCFragmentERNS_7MCValueERy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm11MCAssembler13evaluateFixupERKNS_11MCAsmLayoutERKNS_7MCFixupEPKNS_10MCFragmentERNS_7MCValueERy")
  //</editor-fold>
  private boolean evaluateFixup(final /*const*/ MCAsmLayout /*&*/ Layout, 
               final /*const*/ MCFixup /*&*/ Fixup, /*const*/ MCFragment /*P*/ DF, 
               final MCValue /*&*/ Target, final ulong$ref/*uint64_t &*/ Value) /*const*/ {
    StatsStatics.evaluateFixup.$preInc();
    
    // FIXME: This code has some duplication with recordRelocation. We should
    // probably merge the two into a single callback that tries to evaluate a
    // fixup and records a relocation if one is needed.
    /*const*/ MCExpr /*P*/ Expr = Fixup.getValue();
    if (!Expr.evaluateAsRelocatable(Target, $AddrOf(Layout), $AddrOf(Fixup))) {
      getContext().reportError(Fixup.getLoc(), new Twine(/*KEEP_STR*/"expected relocatable expression"));
      // Claim to have completely evaluated the fixup, to prevent any further
      // processing from being done.
      Value.$set($int2ulong(0));
      return true;
    }
    
    boolean IsPCRel = ((Backend.getFixupKindInfo(Fixup.getKind()).Flags & MCFixupKindInfo.FixupKindFlags.FKF_IsPCRel) != 0);
    
    bool$ref IsResolved = create_bool$ref();
    if (IsPCRel) {
      if ((Target.getSymB() != null)) {
        IsResolved.$set(false);
      } else if (!(Target.getSymA() != null)) {
        IsResolved.$set(false);
      } else {
        /*const*/ MCSymbolRefExpr /*P*/ A = Target.getSymA();
        final /*const*/ MCSymbol /*&*/ SA = A.getSymbol();
        if (A.getKind() != MCSymbolRefExpr.VariantKind.VK_None || SA.isUndefined()) {
          IsResolved.$set(false);
        } else {
          IsResolved.$set(getWriter().isSymbolRefDifferenceFullyResolvedImpl(/*Deref*/this, SA, $Deref(DF), false, true));
        }
      }
    } else {
      IsResolved.$set(Target.isAbsolute());
    }
    
    Value.$set(Target.getConstant());
    {
      
      /*const*/ MCSymbolRefExpr /*P*/ A = Target.getSymA();
      if ((A != null)) {
        final /*const*/ MCSymbol /*&*/ Sym = A.getSymbol();
        if (Sym.isDefined()) {
          Value.$set$addassign(Layout.getSymbolOffset(Sym));
        }
      }
    }
    {
      /*const*/ MCSymbolRefExpr /*P*/ B = Target.getSymB();
      if ((B != null)) {
        final /*const*/ MCSymbol /*&*/ Sym = B.getSymbol();
        if (Sym.isDefined()) {
          Value.$set$minusassign(Layout.getSymbolOffset(Sym));
        }
      }
    }
    
    boolean ShouldAlignPC = ((Backend.getFixupKindInfo(Fixup.getKind()).Flags
       & MCFixupKindInfo.FixupKindFlags.FKF_IsAlignedDownTo32Bits) != 0);
    assert ((ShouldAlignPC ? IsPCRel : true)) : "FKF_IsAlignedDownTo32Bits is only allowed on PC-relative fixups!";
    if (IsPCRel) {
      /*uint32_t*/int Offset = $ullong2uint(Layout.getFragmentOffset(DF) + $uint2ullong(Fixup.getOffset()));
      
      // A number of ARM fixups in Thumb mode require that the effective PC
      // address be determined as the 32-bit aligned version of the actual offset.
      if (ShouldAlignPC) {
        Offset &= ~0x3;
      }
      Value.$set$minusassign($uint2ullong(Offset));
    }
    
    // Let the backend adjust the fixup value if necessary, including whether
    // we need a relocation.
    Backend.processFixupValue(/*Deref*/this, Layout, Fixup, DF, Target, Value, 
        IsResolved);
    
    return IsResolved.$deref();
  }

  
  /// Check whether a fixup can be satisfied, or whether it needs to be relaxed
  /// (increased in size, in order to hold its value correctly).
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::fixupNeedsRelaxation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", line = 730,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", old_line = 709,
   FQN="llvm::MCAssembler::fixupNeedsRelaxation", NM="_ZNK4llvm11MCAssembler20fixupNeedsRelaxationERKNS_7MCFixupEPKNS_19MCRelaxableFragmentERKNS_11MCAsmLayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm11MCAssembler20fixupNeedsRelaxationERKNS_7MCFixupEPKNS_19MCRelaxableFragmentERKNS_11MCAsmLayoutE")
  //</editor-fold>
  private boolean fixupNeedsRelaxation(final /*const*/ MCFixup /*&*/ Fixup, 
                      /*const*/ MCRelaxableFragment /*P*/ DF, 
                      final /*const*/ MCAsmLayout /*&*/ Layout) /*const*/ {
    MCValue Target/*J*/= new MCValue();
    ulong$ref Value = create_ulong$ref();
    boolean Resolved = evaluateFixup(Layout, Fixup, DF, Target, Value);
    return getBackend().fixupNeedsRelaxationAdvanced(Fixup, Resolved, Value.$deref(), DF, 
        Layout);
  }

  
  /// Check whether the given fragment needs relaxation.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::fragmentNeedsRelaxation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", line = 740,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", old_line = 719,
   FQN="llvm::MCAssembler::fragmentNeedsRelaxation", NM="_ZNK4llvm11MCAssembler23fragmentNeedsRelaxationEPKNS_19MCRelaxableFragmentERKNS_11MCAsmLayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm11MCAssembler23fragmentNeedsRelaxationEPKNS_19MCRelaxableFragmentERKNS_11MCAsmLayoutE")
  //</editor-fold>
  private boolean fragmentNeedsRelaxation(/*const*/ MCRelaxableFragment /*P*/ F, 
                         final /*const*/ MCAsmLayout /*&*/ Layout) /*const*/ {
    // If this inst doesn't ever need relaxation, ignore it. This occurs when we
    // are intentionally pushing out inst fragments, or because we relaxed a
    // previous instruction to one that doesn't need relaxation.
    if (!getBackend().mayNeedRelaxation(F.getInst())) {
      return false;
    }
    
    for (final /*const*/ MCFixup /*&*/ Fixup : F.getFixups$Const())  {
      if (fixupNeedsRelaxation(Fixup, F, Layout)) {
        return true;
      }
    }
    
    return false;
  }

  
  /// \brief Perform one layout iteration and return true if any offsets
  /// were adjusted.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::layoutOnce">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", line = 899,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", old_line = 857,
   FQN="llvm::MCAssembler::layoutOnce", NM="_ZN4llvm11MCAssembler10layoutOnceERNS_11MCAsmLayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAssembler10layoutOnceERNS_11MCAsmLayoutE")
  //</editor-fold>
  private boolean layoutOnce(final MCAsmLayout /*&*/ Layout) {
    RelaxationSteps.$preInc();
    
    boolean WasRelaxed = false;
    for (pointee_iterator<MCSection /*P*/ > it = begin(), ie = end(); it.$noteq(ie); it.$preInc()) {
      final MCSection /*&*/ Sec = it.$star();
      while (layoutSectionOnce(Layout, Sec)) {
        WasRelaxed = true;
      }
    }
    
    return WasRelaxed;
  }

  
  /// \brief Perform one layout iteration of the given section and return true
  /// if any offsets were adjusted.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::layoutSectionOnce">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", line = 850,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", old_line = 815,
   FQN="llvm::MCAssembler::layoutSectionOnce", NM="_ZN4llvm11MCAssembler17layoutSectionOnceERNS_11MCAsmLayoutERNS_9MCSectionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAssembler17layoutSectionOnceERNS_11MCAsmLayoutERNS_9MCSectionE")
  //</editor-fold>
  private boolean layoutSectionOnce(final MCAsmLayout /*&*/ Layout, final MCSection /*&*/ Sec) {
    // Holds the first fragment which needed relaxing during this layout. It will
    // remain NULL if none were relaxed.
    // When a fragment is relaxed, all the fragments following it should get
    // invalidated because their offset is going to change.
    MCFragment /*P*/ FirstRelaxedFragment = null;
    
    // Attempt to relax all the fragments in the section.
    for (ilist_iterator<MCFragment> I = Sec.begin(), IE = Sec.end(); I.$noteq(IE); I.$preInc()) {
      // Check if this is a fragment that needs relaxation.
      boolean RelaxedFrag = false;
      switch (I.$arrow().getKind()) {
       default:
        break;
       case FT_Relaxable:
        assert (!getRelaxAll()) : "Did not expect a MCRelaxableFragment in RelaxAll mode";
        RelaxedFrag = relaxInstruction(Layout, cast_MCRelaxableFragment(I.$star()));
        break;
       case FT_Dwarf:
        RelaxedFrag = relaxDwarfLineAddr(Layout, 
            cast_MCDwarfLineAddrFragment(I.$star()));
        break;
       case FT_DwarfFrame:
        RelaxedFrag
           = relaxDwarfCallFrameFragment(Layout, 
            cast_MCDwarfCallFrameFragment(I.$star()));
        break;
       case FT_LEB:
        RelaxedFrag = relaxLEB(Layout, cast_MCLEBFragment(I.$star()));
        break;
       case FT_CVInlineLines:
        RelaxedFrag
           = relaxCVInlineLineTable(Layout, cast_MCCVInlineLineTableFragment(I.$star()));
        break;
       case FT_CVDefRange:
        RelaxedFrag = relaxCVDefRange(Layout, cast_MCCVDefRangeFragment(I.$star()));
        break;
      }
      if (RelaxedFrag && !(FirstRelaxedFragment != null)) {
        FirstRelaxedFragment = $AddrOf(I.$star());
      }
    }
    if ((FirstRelaxedFragment != null)) {
      Layout.invalidateFragmentsFrom(FirstRelaxedFragment);
      return true;
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::relaxInstruction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", line = 755,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", old_line = 734,
   FQN="llvm::MCAssembler::relaxInstruction", NM="_ZN4llvm11MCAssembler16relaxInstructionERNS_11MCAsmLayoutERNS_19MCRelaxableFragmentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAssembler16relaxInstructionERNS_11MCAsmLayoutERNS_19MCRelaxableFragmentE")
  //</editor-fold>
  private boolean relaxInstruction(final MCAsmLayout /*&*/ Layout, 
                  final MCRelaxableFragment /*&*/ F) {
    MCInst Relaxed = null;
    raw_svector_ostream VecOS = null;
    try {
      if (!fragmentNeedsRelaxation($AddrOf(F), Layout)) {
        return false;
      }
      
      StatsStatics.RelaxedInstructions.$preInc();
      
      // FIXME-PERF: We could immediately lower out instructions if we can tell
      // they are fully resolved, to avoid retesting on later passes.
      
      // Relax the fragment.
      Relaxed/*J*/= new MCInst();
      getBackend().relaxInstruction(F.getInst(), F.getSubtargetInfo(), Relaxed);
      
      // Encode the new instruction.
      //
      // FIXME-PERF: If it matters, we could let the target do this. It can
      // probably do so more efficiently in many cases.
      SmallVector<MCFixup> Fixups/*J*/= new SmallVector<MCFixup>(4, new MCFixup());
      SmallString/*256*/ Code/*J*/= new SmallString/*256*/(256);
      VecOS/*J*/= new raw_svector_ostream(Code);
      getEmitter().encodeInstruction(Relaxed, VecOS, Fixups, F.getSubtargetInfo());
      
      // Update the fragment.
      F.setInst(Relaxed);
      F.getContents().$assign(Code);
      F.getFixups().$assign(Fixups);
      
      return true;
    } finally {
      if (VecOS != null) { VecOS.$destroy(); }
      if (Relaxed != null) { Relaxed.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::relaxLEB">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", line = 787,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", old_line = 766,
   FQN="llvm::MCAssembler::relaxLEB", NM="_ZN4llvm11MCAssembler8relaxLEBERNS_11MCAsmLayoutERNS_13MCLEBFragmentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAssembler8relaxLEBERNS_11MCAsmLayoutERNS_13MCLEBFragmentE")
  //</editor-fold>
  private boolean relaxLEB(final MCAsmLayout /*&*/ Layout, final MCLEBFragment /*&*/ LF) {
    raw_svector_ostream OSE = null;
    try {
      long/*uint64_t*/ OldSize = $uint2ulong(LF.getContents().size());
      long$ref Value = create_long$ref();
      boolean Abs = LF.getValue().evaluateKnownAbsolute(Value, Layout);
      if (!Abs) {
        report_fatal_error($("sleb128 and uleb128 expressions must be absolute"));
      }
      final SmallString/*8*/ /*&*/ Data = LF.getContents();
      Data.clear();
      OSE/*J*/= new raw_svector_ostream(Data);
      if (LF.isSigned()) {
        encodeSLEB128(Value.$deref(), OSE);
      } else {
        encodeULEB128(Value.$deref(), OSE);
      }
      return OldSize != $uint2ullong(LF.getContents().size());
    } finally {
      if (OSE != null) { OSE.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::relaxDwarfLineAddr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", line = 803,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", old_line = 782,
   FQN="llvm::MCAssembler::relaxDwarfLineAddr", NM="_ZN4llvm11MCAssembler18relaxDwarfLineAddrERNS_11MCAsmLayoutERNS_23MCDwarfLineAddrFragmentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAssembler18relaxDwarfLineAddrERNS_11MCAsmLayoutERNS_23MCDwarfLineAddrFragmentE")
  //</editor-fold>
  private boolean relaxDwarfLineAddr(final MCAsmLayout /*&*/ Layout, 
                    final MCDwarfLineAddrFragment /*&*/ DF) {
    raw_svector_ostream OSE = null;
    try {
      final MCContext /*&*/ Context = Layout.getAssembler().getContext();
      long/*uint64_t*/ OldSize = $uint2ulong(DF.getContents().size());
      long$ref AddrDelta = create_long$ref();
      boolean Abs = DF.getAddrDelta().evaluateKnownAbsolute(AddrDelta, Layout);
      assert (Abs) : "We created a line delta with an invalid expression";
      ///*J:(void)*/Abs;
      long/*int64_t*/ LineDelta;
      LineDelta = DF.getLineDelta();
      final SmallString/*8*/ /*&*/ Data = DF.getContents();
      Data.clear();
      OSE/*J*/= new raw_svector_ostream(Data);
      MCDwarfLineAddr.Encode(Context, getDWARFLinetableParams(), LineDelta, 
          AddrDelta.$deref(), OSE);
      return OldSize != $uint2ullong(Data.size());
    } finally {
      if (OSE != null) { OSE.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::relaxDwarfCallFrameFragment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", line = 821,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", old_line = 800,
   FQN="llvm::MCAssembler::relaxDwarfCallFrameFragment", NM="_ZN4llvm11MCAssembler27relaxDwarfCallFrameFragmentERNS_11MCAsmLayoutERNS_24MCDwarfCallFrameFragmentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAssembler27relaxDwarfCallFrameFragmentERNS_11MCAsmLayoutERNS_24MCDwarfCallFrameFragmentE")
  //</editor-fold>
  private boolean relaxDwarfCallFrameFragment(final MCAsmLayout /*&*/ Layout, 
                             final MCDwarfCallFrameFragment /*&*/ DF) {
    raw_svector_ostream OSE = null;
    try {
      final MCContext /*&*/ Context = Layout.getAssembler().getContext();
      long/*uint64_t*/ OldSize = $uint2ulong(DF.getContents().size());
      long$ref AddrDelta = create_long$ref();
      boolean Abs = DF.getAddrDelta().evaluateKnownAbsolute(AddrDelta, Layout);
      assert (Abs) : "We created call frame with an invalid expression";
      ///*J:(void)*/Abs;
      final SmallString/*8*/ /*&*/ Data = DF.getContents();
      Data.clear();
      OSE/*J*/= new raw_svector_ostream(Data);
      MCDwarfFrameEmitter.EncodeAdvanceLoc(Context, AddrDelta.$deref(), OSE);
      return OldSize != $uint2ullong(Data.size());
    } finally {
      if (OSE != null) { OSE.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::relaxCVInlineLineTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", line = 836,
   FQN="llvm::MCAssembler::relaxCVInlineLineTable", NM="_ZN4llvm11MCAssembler22relaxCVInlineLineTableERNS_11MCAsmLayoutERNS_27MCCVInlineLineTableFragmentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAssembler22relaxCVInlineLineTableERNS_11MCAsmLayoutERNS_27MCCVInlineLineTableFragmentE")
  //</editor-fold>
  private boolean relaxCVInlineLineTable(final MCAsmLayout /*&*/ Layout, 
                        final MCCVInlineLineTableFragment /*&*/ F) {
    /*uint*/int OldSize = F.getContents().size();
    getContext().getCVContext().encodeInlineLineTable(Layout, F);
    return OldSize != F.getContents().size();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::relaxCVDefRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", line = 843,
   FQN="llvm::MCAssembler::relaxCVDefRange", NM="_ZN4llvm11MCAssembler15relaxCVDefRangeERNS_11MCAsmLayoutERNS_20MCCVDefRangeFragmentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAssembler15relaxCVDefRangeERNS_11MCAsmLayoutERNS_20MCCVDefRangeFragmentE")
  //</editor-fold>
  private boolean relaxCVDefRange(final MCAsmLayout /*&*/ Layout, 
                 final MCCVDefRangeFragment /*&*/ F) {
    /*uint*/int OldSize = F.getContents().size();
    getContext().getCVContext().encodeDefRange(Layout, F);
    return OldSize != F.getContents().size();
  }

  
  /// finishLayout - Finalize a layout, including fragment lowering.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::finishLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", line = 912,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", old_line = 870,
   FQN="llvm::MCAssembler::finishLayout", NM="_ZN4llvm11MCAssembler12finishLayoutERNS_11MCAsmLayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAssembler12finishLayoutERNS_11MCAsmLayoutE")
  //</editor-fold>
  private void finishLayout(final MCAsmLayout /*&*/ Layout) {
    // The layout is done. Mark every fragment as valid.
    for (/*uint*/int i = 0, n = Layout.getSectionOrder().size(); i != n; ++i) {
      Layout.getFragmentOffset($AddrOf(Layout.getSectionOrder().$at(i).rbegin().$star()));
    }
    getBackend().finishLayout(/*Deref*/this, Layout);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::handleFixup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", line = 617,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", old_line = 601,
   FQN="llvm::MCAssembler::handleFixup", NM="_ZN4llvm11MCAssembler11handleFixupERKNS_11MCAsmLayoutERNS_10MCFragmentERKNS_7MCFixupE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAssembler11handleFixupERKNS_11MCAsmLayoutERNS_10MCFragmentERKNS_7MCFixupE")
  //</editor-fold>
  private std.pairULongBool handleFixup(final /*const*/ MCAsmLayout /*&*/ Layout, 
             final MCFragment /*&*/ F, 
             final /*const*/ MCFixup /*&*/ Fixup) {
    // Evaluate the fixup.
    MCValue Target/*J*/= new MCValue();
    ulong$ref FixedValue = create_ulong$ref();
    bool$ref IsPCRel = create_bool$ref(((Backend.getFixupKindInfo(Fixup.getKind()).Flags
       & MCFixupKindInfo.FixupKindFlags.FKF_IsPCRel) != 0));
    if (!evaluateFixup(Layout, Fixup, $AddrOf(F), Target, FixedValue)) {
      // The fixup was unresolved, we need a relocation. Inform the object
      // writer of the relocation, and give it an opportunity to adjust the
      // fixup value if need be.
      getWriter().recordRelocation(/*Deref*/this, Layout, $AddrOf(F), Fixup, new MCValue(Target), IsPCRel, 
          FixedValue);
    }
    return std.make_pair_ullong_bool(FixedValue.$deref(), IsPCRel.$deref());
  }

/*public:*/
  /// Compute the effective fragment size assuming it is laid out at the given
  /// \p SectionAddress and \p FragmentOffset.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::computeFragmentSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", line = 245,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", old_line = 244,
   FQN="llvm::MCAssembler::computeFragmentSize", NM="_ZNK4llvm11MCAssembler19computeFragmentSizeERKNS_11MCAsmLayoutERKNS_10MCFragmentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm11MCAssembler19computeFragmentSizeERKNS_11MCAsmLayoutERKNS_10MCFragmentE")
  //</editor-fold>
  public long/*uint64_t*/ computeFragmentSize(final /*const*/ MCAsmLayout /*&*/ Layout, 
                     final /*const*/ MCFragment /*&*/ F) /*const*/ {
    switch (F.getKind()) {
     case FT_Data:
      return $uint2ulong(cast_MCDataFragment(F).getContents$Const().size());
     case FT_Relaxable:
      return $uint2ulong(cast_MCRelaxableFragment(F).getContents$Const().size());
     case FT_CompactEncodedInst:
      return $uint2ulong(cast_MCCompactEncodedInstFragment(F).getContents$Const().size());
     case FT_Fill:
      return cast_MCFillFragment(F).getSize();
     case FT_LEB:
      return $uint2ulong(cast_MCLEBFragment(F).getContents$Const().size());
     case FT_SafeSEH:
      return $int2ulong(4);
     case FT_Align:
      {
        final /*const*/ MCAlignFragment /*&*/ AF = cast_MCAlignFragment(F);
        /*uint*/int Offset = $ulong2uint(Layout.getFragmentOffset($AddrOf(AF)));
        /*uint*/int Size = $ulong2uint(OffsetToAlignment($uint2ulong(Offset), $uint2ulong(AF.getAlignment())));
        // If we are padding with nops, force the padding to be larger than the
        // minimum nop size.
        if ($greater_uint(Size, 0) && AF.hasEmitNops()) {
          while ((($rem_uint(Size, getBackend().getMinimumNopSize())) != 0)) {
            Size += AF.getAlignment();
          }
        }
        if ($greater_uint(Size, AF.getMaxBytesToEmit())) {
          return $int2ulong(0);
        }
        return $uint2ulong(Size);
      }
     case FT_Org:
      {
        final /*const*/ MCOrgFragment /*&*/ OF = cast_MCOrgFragment(F);
        MCValue Value/*J*/= new MCValue();
        if (!OF.getOffset().evaluateAsValue(Value, Layout)) {
          report_fatal_error($("expected assembly-time absolute expression"));
        }
        
        // FIXME: We need a way to communicate this error.
        long/*uint64_t*/ FragmentOffset = Layout.getFragmentOffset($AddrOf(OF));
        long/*int64_t*/ TargetLocation = Value.getConstant();
        {
          /*const*/ MCSymbolRefExpr /*P*/ A = Value.getSymA();
          if ((A != null)) {
            ulong$ref Val = create_ulong$ref();
            if (!Layout.getSymbolOffset(A.getSymbol(), Val)) {
              report_fatal_error($("expected absolute expression"));
            }
            TargetLocation += Val.$deref();
          }
        }
        long/*int64_t*/ Size = TargetLocation - FragmentOffset;
        if (Size < 0 || Size >= 0x40000000) {
          report_fatal_error(
                  llvm.$add_Twine$C(
                          llvm.$add_Twine$C(
                                  llvm.$add_Twine$C(
                                          llvm.$add_Twine$C(
                                                  new Twine(/*KEEP_STR*/"invalid .org offset '"),
                                                  new Twine(JD$Long$C.INSTANCE, TargetLocation)), 
                          new Twine(/*KEEP_STR*/"' (at offset '")),
                                  new Twine(JD$ConstULLongRef.INSTANCE, FragmentOffset)), new Twine(/*KEEP_STR*/"')")));
        }
        return Size;
      }
     case FT_Dwarf:
      return $uint2ulong(cast_MCDwarfLineAddrFragment(F).getContents$Const().size());
     case FT_DwarfFrame:
      return $uint2ulong(cast_MCDwarfCallFrameFragment(F).getContents$Const().size());
     case FT_CVInlineLines:
      return $uint2ulong(cast_MCCVInlineLineTableFragment(F).getContents$Const().size());
     case FT_CVDefRange:
      return $uint2ulong(cast_MCCVDefRangeFragment(F).getContents$Const().size());
     case FT_Dummy:
      throw new llvm_unreachable("Should not have been added");
    }
    throw new llvm_unreachable("invalid fragment kind");
  }

  
  /// Find the symbol which defines the atom containing the given symbol, or
  /// null if there is no such symbol.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::getAtom">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", line = 150,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", old_line = 149,
   FQN="llvm::MCAssembler::getAtom", NM="_ZNK4llvm11MCAssembler7getAtomERKNS_8MCSymbolE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm11MCAssembler7getAtomERKNS_8MCSymbolE")
  //</editor-fold>
  public /*const*/ MCSymbol /*P*/ getAtom(final /*const*/ MCSymbol /*&*/ S) /*const*/ {
    // Linker visible symbols define atoms.
    if (isSymbolLinkerVisible(S)) {
      return $AddrOf(S);
    }
    
    // Absolute and undefined symbols have no defining atom.
    if (!S.isInSection()) {
      return null;
    }
    
    // Non-linker visible symbols in sections which can't be atomized have no
    // defining atom.
    if (!getContext().getAsmInfo().isSectionAtomizableBySymbols($Deref(S.getFragment().getParent()))) {
      return null;
    }
    
    // Otherwise, return the atom for the containing fragment.
    return S.getFragment().getAtom();
  }

  
  /// Check whether a particular symbol is visible to the linker and is required
  /// in the symbol table, or whether it can be discarded by the assembler. This
  /// also effects whether the assembler treats the label as potentially
  /// defining a separate atom.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::isSymbolLinkerVisible">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", line = 135,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", old_line = 134,
   FQN="llvm::MCAssembler::isSymbolLinkerVisible", NM="_ZNK4llvm11MCAssembler21isSymbolLinkerVisibleERKNS_8MCSymbolE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm11MCAssembler21isSymbolLinkerVisibleERKNS_8MCSymbolE")
  //</editor-fold>
  public boolean isSymbolLinkerVisible(final /*const*/ MCSymbol /*&*/ Symbol) /*const*/ {
    // Non-temporary labels should always be visible to the linker.
    if (!Symbol.isTemporary()) {
      return true;
    }
    
    // Absolute temporary labels are never visible.
    if (!Symbol.isInSection()) {
      return false;
    }
    if (Symbol.isUsedInReloc()) {
      return true;
    }
    
    return false;
  }

  
  /// Emit the section contents using the given object writer.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::writeSectionData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", line = 563,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", old_line = 546,
   FQN="llvm::MCAssembler::writeSectionData", NM="_ZNK4llvm11MCAssembler16writeSectionDataEPKNS_9MCSectionERKNS_11MCAsmLayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm11MCAssembler16writeSectionDataEPKNS_9MCSectionERKNS_11MCAsmLayoutE")
  //</editor-fold>
  public void writeSectionData(/*const*/ MCSection /*P*/ Sec, 
                  final /*const*/ MCAsmLayout /*&*/ Layout) /*const*/ {
    // Ignore virtual sections.
    if (Sec.isVirtualSection()) {
      assert (Layout.getSectionFileSize(Sec) == $int2ullong(0)) : "Invalid size for section!";
      
      // Check that contents are only things legal inside a virtual section.
      for (final /*const*/ MCFragment /*&*/ F : $Deref(Sec)) {
        switch (F.getKind()) {
         default:
          throw new llvm_unreachable("Invalid fragment in virtual section!");
         case FT_Data:
          {
            // Check that we aren't trying to write a non-zero contents (or fixups)
            // into a virtual section. This is to support clients which use standard
            // directives to fill the contents of virtual sections.
            final /*const*/ MCDataFragment /*&*/ DF = cast_MCDataFragment(F);
            assert ($eq_ptr(DF.fixup_begin$Const(), DF.fixup_end$Const())) : "Cannot have fixups in virtual section!";
            for (/*uint*/int i = 0, e = DF.getContents$Const().size(); i != e; ++i)  {
              if ((DF.getContents$Const().$at$Const(i) != 0)) {
                {
                  /*const*/ MCSectionELF /*P*/ ELFSec = dyn_cast_MCSectionELF(Sec);
                  if ((ELFSec != null)) {
                    report_fatal_error(llvm.$add_Twine$C($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"non-zero initializer found in section '", 
                                ELFSec.getSectionName()), new Twine(/*KEEP_STR*/$SGL_QUOTE)));
                  } else {
                    report_fatal_error($("non-zero initializer found in virtual section"));
                  }
                }
              }
            }
            break;
          }
         case FT_Align:
          // Check that we aren't trying to write a non-zero value into a virtual
          // section.
          assert ((cast_MCAlignFragment(F).getValueSize() == 0 || cast_MCAlignFragment(F).getValue() == 0)) : "Invalid align in virtual section!";
          break;
         case FT_Fill:
          assert (($uchar2int(cast_MCFillFragment(F).getValue()) == 0)) : "Invalid fill in virtual section!";
          break;
        }
      }
      
      return;
    }
    
    long/*uint64_t*/ Start = getWriter().getStream().tell();
    ///*J:(void)*/Start;
    
    for (final /*const*/ MCFragment /*&*/ F : $Deref(Sec))  {
      MCAssemblerStatics.writeFragment(/*Deref*/this, Layout, F);
    }
    assert (getWriter().getStream().tell() - Start == Layout.getSectionAddressSize(Sec));
  }

  
  /// Check whether a given symbol has been flagged with .thumb_func.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::isThumbFunc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", line = 110,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", old_line = 109,
   FQN="llvm::MCAssembler::isThumbFunc", NM="_ZNK4llvm11MCAssembler11isThumbFuncEPKNS_8MCSymbolE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm11MCAssembler11isThumbFuncEPKNS_8MCSymbolE")
  //</editor-fold>
  public boolean isThumbFunc(/*const*/ MCSymbol /*P*/ Symbol) /*const*/ {
    if ((ThumbFuncs.count(Symbol) != 0)) {
      return true;
    }
    if (!Symbol.isVariable()) {
      return false;
    }
    
    // FIXME: It looks like gas supports some cases of the form "foo + 2". It
    // is not clear if that is a bug or a feature.
    /*const*/ MCExpr /*P*/ Expr = Symbol.getVariableValue();
    /*const*/ MCSymbolRefExpr /*P*/ Ref = dyn_cast_MCSymbolRefExpr(Expr);
    if (!(Ref != null)) {
      return false;
    }
    if (Ref.getKind() != MCSymbolRefExpr.VariantKind.VK_None) {
      return false;
    }
    
    final /*const*/ MCSymbol /*&*/ Sym = Ref.getSymbol();
    if (!isThumbFunc($AddrOf(Sym))) {
      return false;
    }
    
    ThumbFuncs.insert(Symbol); // Cache it.
    return true;
  }

  
  /// Flag a function symbol as the target of a .thumb_func directive.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::setIsThumbFunc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 226,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 223,
   FQN="llvm::MCAssembler::setIsThumbFunc", NM="_ZN4llvm11MCAssembler14setIsThumbFuncEPKNS_8MCSymbolE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAssembler14setIsThumbFuncEPKNS_8MCSymbolE")
  //</editor-fold>
  public void setIsThumbFunc(/*const*/ MCSymbol /*P*/ Func) {
    ThumbFuncs.insert(Func);
  }

  
  /// ELF e_header flags
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::getELFHeaderEFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 229,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 226,
   FQN="llvm::MCAssembler::getELFHeaderEFlags", NM="_ZNK4llvm11MCAssembler18getELFHeaderEFlagsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm11MCAssembler18getELFHeaderEFlagsEv")
  //</editor-fold>
  public /*uint*/int getELFHeaderEFlags() /*const*/ {
    return ELFHeaderEFlags;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::setELFHeaderEFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 230,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 227,
   FQN="llvm::MCAssembler::setELFHeaderEFlags", NM="_ZN4llvm11MCAssembler18setELFHeaderEFlagsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAssembler18setELFHeaderEFlagsEj")
  //</editor-fold>
  public void setELFHeaderEFlags(/*uint*/int Flags) {
    ELFHeaderEFlags = Flags;
  }

  
  /// MachO deployment target version information.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::getVersionMinInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 233,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 230,
   FQN="llvm::MCAssembler::getVersionMinInfo", NM="_ZNK4llvm11MCAssembler17getVersionMinInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm11MCAssembler17getVersionMinInfoEv")
  //</editor-fold>
  public /*const*/  VersionMinInfoType /*&*/ getVersionMinInfo() /*const*/ {
    return VersionMinInfo;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::setVersionMinInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 234,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 231,
   FQN="llvm::MCAssembler::setVersionMinInfo", NM="_ZN4llvm11MCAssembler17setVersionMinInfoENS_16MCVersionMinTypeEjjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAssembler17setVersionMinInfoENS_16MCVersionMinTypeEjjj")
  //</editor-fold>
  public void setVersionMinInfo(MCVersionMinType Kind, /*uint*/int Major, /*uint*/int Minor, 
                   /*uint*/int Update) {
    VersionMinInfo.Kind = Kind;
    VersionMinInfo.Major = Major;
    VersionMinInfo.Minor = Minor;
    VersionMinInfo.Update = Update;
  }

/*public:*/
  /// Construct a new assembler instance.
  //
  // FIXME: How are we going to parameterize this? Two obvious options are stay
  // concrete and require clients to pass in a target like object. The other
  // option is to make this abstract, and have targets provide concrete
  // implementations as we do with AsmParser.
  
  // FIXME FIXME FIXME: There are number of places in this file where we convert
  // what is a 64-bit assembler value used for computation into a value in the
  // object file, which may truncate it. We should detect that truncation where
  // invalid and report errors back.
  
  /* *** */
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::MCAssembler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", line = 68,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", old_line = 67,
   FQN="llvm::MCAssembler::MCAssembler", NM="_ZN4llvm11MCAssemblerC1ERNS_9MCContextERNS_12MCAsmBackendERNS_13MCCodeEmitterERNS_14MCObjectWriterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAssemblerC1ERNS_9MCContextERNS_12MCAsmBackendERNS_13MCCodeEmitterERNS_14MCObjectWriterE")
  //</editor-fold>
  public MCAssembler(final MCContext /*&*/ Context, final MCAsmBackend /*&*/ Backend, 
      final MCCodeEmitter /*&*/ Emitter, final MCObjectWriter /*&*/ Writer) {
    // : Context(Context), Backend(Backend), Emitter(Emitter), Writer(Writer), Sections(), Symbols(), IndirectSymbols(), DataRegions(), LinkerOptions(), FileNames(), LTParams(), ThumbFuncs(), BundleAlignSize(0), RelaxAll(false), SubsectionsViaSymbols(false), IncrementalLinkerCompatible(false), ELFHeaderEFlags(0), LOHContainer(), VersionMinInfo() 
    //START JInit
    this./*&*/Context=/*&*/Context;
    this./*&*/Backend=/*&*/Backend;
    this./*&*/Emitter=/*&*/Emitter;
    this./*&*/Writer=/*&*/Writer;
    this.Sections = new std.vector<MCSection /*P*/ >((MCSection /*P*/ )null);
    this.Symbols = new std.vector</*const*/ MCSymbol /*P*/ >((/*const*/ MCSymbol /*P*/ )null);
    this.IndirectSymbols = new std.vector<IndirectSymbolData>(new IndirectSymbolData());
    this.DataRegions = new std.vector<DataRegionData>(new DataRegionData());
    this.LinkerOptions = new std.vector<std.vectorString>(new std.vectorString(std.string.EMPTY));
    this.FileNames = new std.vectorString(std.string.EMPTY);
    this.LTParams = new MCDwarfLineTableParams();
    this.ThumbFuncs = new SmallPtrSet</*const*/ MCSymbol /*P*/ >(DenseMapInfo$LikePtr.$Info(), 32);
    this.BundleAlignSize = 0;
    this.RelaxAll = false;
    this.SubsectionsViaSymbols = false;
    this.IncrementalLinkerCompatible = false;
    this.ELFHeaderEFlags = 0;
    this.LOHContainer = new MCLOHContainer();
    this.VersionMinInfo = new  VersionMinInfoType();
    //END JInit
    VersionMinInfo.Major = 0; // Major version == 0 for "none specified"
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::~MCAssembler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", line = 76,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", old_line = 75,
   FQN="llvm::MCAssembler::~MCAssembler", NM="_ZN4llvm11MCAssemblerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAssemblerD0Ev")
  //</editor-fold>
  public void $destroy() {
    //START JDestroy
    LOHContainer.$destroy();
    ThumbFuncs.$destroy();
    FileNames.$destroy();
    LinkerOptions.$destroy();
    DataRegions.$destroy();
    IndirectSymbols.$destroy();
    Symbols.$destroy();
    Sections.$destroy();
    //END JDestroy
  }

  
  /// Reuse an assembler instance
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::reset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", line = 79,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", old_line = 78,
   FQN="llvm::MCAssembler::reset", NM="_ZN4llvm11MCAssembler5resetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAssembler5resetEv")
  //</editor-fold>
  public void reset() {
    Sections.clear();
    Symbols.clear();
    IndirectSymbols.clear();
    DataRegions.clear();
    LinkerOptions.clear();
    FileNames.clear();
    ThumbFuncs.clear();
    BundleAlignSize = 0;
    RelaxAll = false;
    SubsectionsViaSymbols = false;
    IncrementalLinkerCompatible = false;
    ELFHeaderEFlags = 0;
    LOHContainer.reset();
    VersionMinInfo.Major = 0;
    
    // reset objects owned by us
    getBackend().reset();
    getEmitter().reset();
    getWriter().reset();
    getLOHContainer().reset();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::getContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 257,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 254,
   FQN="llvm::MCAssembler::getContext", NM="_ZNK4llvm11MCAssembler10getContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm11MCAssembler10getContextEv")
  //</editor-fold>
  public MCContext /*&*/ getContext() /*const*/ {
    return Context;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::getBackend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 259,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 256,
   FQN="llvm::MCAssembler::getBackend", NM="_ZNK4llvm11MCAssembler10getBackendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm11MCAssembler10getBackendEv")
  //</editor-fold>
  public MCAsmBackend /*&*/ getBackend() /*const*/ {
    return Backend;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::getEmitter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 261,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 258,
   FQN="llvm::MCAssembler::getEmitter", NM="_ZNK4llvm11MCAssembler10getEmitterEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm11MCAssembler10getEmitterEv")
  //</editor-fold>
  public MCCodeEmitter /*&*/ getEmitter() /*const*/ {
    return Emitter;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::getWriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 263,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 260,
   FQN="llvm::MCAssembler::getWriter", NM="_ZNK4llvm11MCAssembler9getWriterEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm11MCAssembler9getWriterEv")
  //</editor-fold>
  public MCObjectWriter /*&*/ getWriter() /*const*/ {
    return Writer;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::getDWARFLinetableParams">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 265,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 262,
   FQN="llvm::MCAssembler::getDWARFLinetableParams", NM="_ZNK4llvm11MCAssembler23getDWARFLinetableParamsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm11MCAssembler23getDWARFLinetableParamsEv")
  //</editor-fold>
  public MCDwarfLineTableParams getDWARFLinetableParams() /*const*/ {
    return new MCDwarfLineTableParams(LTParams);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::setDWARFLinetableParams">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 266,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 263,
   FQN="llvm::MCAssembler::setDWARFLinetableParams", NM="_ZN4llvm11MCAssembler23setDWARFLinetableParamsENS_22MCDwarfLineTableParamsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAssembler23setDWARFLinetableParamsENS_22MCDwarfLineTableParamsE")
  //</editor-fold>
  public void setDWARFLinetableParams(MCDwarfLineTableParams P) {
    LTParams.$assign(P);
  }

  
  /// Finish - Do final processing and write the object to the output stream.
  /// \p Writer is used for custom object writer (as the MCJIT does),
  /// if not specified it is automatically created from backend.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::Finish">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", line = 716,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", old_line = 695,
   FQN="llvm::MCAssembler::Finish", NM="_ZN4llvm11MCAssembler6FinishEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAssembler6FinishEv")
  //</editor-fold>
  public void Finish() {
    MCAsmLayout Layout = null;
    try {
      // Create the layout object.
      Layout/*J*/= new MCAsmLayout(/*Deref*/this);
      layout(Layout);
      
      final raw_ostream /*&*/ OS = getWriter().getStream();
      long/*uint64_t*/ StartOffset = OS.tell();
      
      // Write the object file.
      getWriter().writeObject(/*Deref*/this, Layout);
      
      StatsStatics.ObjectBytes.$addassign($ullong2uint(OS.tell() - StartOffset));
    } finally {
      if (Layout != null) { Layout.$destroy(); }
    }
  }

  
  // Layout all section and prepare them for emission.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::layout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", line = 635,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", old_line = 619,
   FQN="llvm::MCAssembler::layout", NM="_ZN4llvm11MCAssembler6layoutERNS_11MCAsmLayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAssembler6layoutERNS_11MCAsmLayoutE")
  //</editor-fold>
  public void layout(final MCAsmLayout /*&*/ Layout) {
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"mc-dump")) {
        {
          llvm.errs().$out(/*KEEP_STR*/"assembler backend - pre-layout\n--\n");
          dump();
        }
        ;
      }
    } while (false);
    
    // Create dummy fragments and assign section ordinals.
    /*uint*/int SectionIndex = 0;
    for (final MCSection /*&*/ Sec : /*Deref*/this) {
      // Create dummy fragments to eliminate any empty sections, this simplifies
      // layout.
      if (Sec.getFragmentList().empty()) {
        new MCDataFragment($AddrOf(Sec));
      }
      
      Sec.setOrdinal(SectionIndex++);
    }
    
    // Assign layout order indices to sections and fragments.
    for (/*uint*/int i = 0, e = Layout.getSectionOrder().size(); i != e; ++i) {
      MCSection /*P*/ Sec = Layout.getSectionOrder().$at(i);
      Sec.setLayoutOrder(i);
      
      /*uint*/int FragmentIndex = 0;
      for (final MCFragment /*&*/ Frag : $Deref(Sec))  {
        Frag.setLayoutOrder(FragmentIndex++);
      }
    }
    
    // Layout until everything fits.
    while (layoutOnce(Layout)) {
      continue;
    }
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"mc-dump")) {
        {
          llvm.errs().$out(/*KEEP_STR*/"assembler backend - post-relaxation\n--\n");
          dump();
        }
        ;
      }
    } while (false);
    
    // Finalize the layout, including fragment lowering.
    finishLayout(Layout);
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"mc-dump")) {
        {
          llvm.errs().$out(/*KEEP_STR*/"assembler backend - final-layout\n--\n");
          dump();
        }
        ;
      }
    } while (false);
    
    // Allow the object writer a chance to perform post-layout binding (for
    // example, to set the index fields in the symbol data).
    getWriter().executePostLayoutBinding(/*Deref*/this, Layout);
    
    // Evaluate and apply the fixups, generating relocation entries as necessary.
    for (final MCSection /*&*/ Sec : /*Deref*/this) {
      for (final MCFragment /*&*/ Frag : Sec) {
        // Data and relaxable fragments both have fixups.  So only process
        // those here.
        // FIXME: Is there a better way to do this?  MCEncodedFragmentWithFixups
        // being templated makes this tricky.
        if (isa_MCEncodedFragment($AddrOf(Frag))
           && isa_MCCompactEncodedInstFragment($AddrOf(Frag))) {
          continue;
        }
        if (!isa_MCEncodedFragment($AddrOf(Frag)) && !isa_MCCVDefRangeFragment($AddrOf(Frag))) {
          continue;
        }
        ArrayRef<MCFixup> Fixups/*J*/= new ArrayRef<MCFixup>(false);
        MutableArrayRefChar Contents/*J*/= new MutableArrayRefChar();
        {
          MCDataFragment /*P*/ FragWithFixups = dyn_cast_MCDataFragment($AddrOf(Frag));
          if ((FragWithFixups != null)) {
            Fixups.$assignMove(new ArrayRef<MCFixup>(FragWithFixups.getFixups(), false));
            Contents.$assignMove(new MutableArrayRefChar(FragWithFixups.getContents()));
          } else {
            MCRelaxableFragment /*P*/ FragWithFixups$1 = dyn_cast_MCRelaxableFragment($AddrOf(Frag));
            if ((FragWithFixups$1 != null)) {
              Fixups.$assignMove(new ArrayRef<MCFixup>(FragWithFixups$1.getFixups(), false));
              Contents.$assignMove(new MutableArrayRefChar(FragWithFixups$1.getContents()));
            } else {
              MCCVDefRangeFragment /*P*/ FragWithFixups$2 = dyn_cast_MCCVDefRangeFragment($AddrOf(Frag));
              if ((FragWithFixups$2 != null)) {
                Fixups.$assignMove(new ArrayRef<MCFixup>(FragWithFixups$2.getFixups(), false));
                Contents.$assignMove(new MutableArrayRefChar(FragWithFixups$2.getContents()));
              } else {
                throw new llvm_unreachable("Unknown fragment with fixups!");
              }
            }
          }
        }
        for (final /*const*/ MCFixup /*&*/ Fixup : Fixups) {
          pairULongBool tmp = handleFixup(Layout, Frag, Fixup);
          long/*uint64_t*/ FixedValue = tmp.first;
          boolean IsPCRel = tmp.second;
          //std.tie(FixedValue, IsPCRel).$assign(handleFixup(Layout, Frag, Fixup));
          getBackend().applyFixup(Fixup, Contents.data(), 
              Contents.size(), FixedValue, IsPCRel);
        }
      }
    }
  }

  
  // FIXME: This does not belong here.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::getSubsectionsViaSymbols">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 277,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 274,
   FQN="llvm::MCAssembler::getSubsectionsViaSymbols", NM="_ZNK4llvm11MCAssembler24getSubsectionsViaSymbolsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm11MCAssembler24getSubsectionsViaSymbolsEv")
  //</editor-fold>
  public boolean getSubsectionsViaSymbols() /*const*/ {
    return SubsectionsViaSymbols;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::setSubsectionsViaSymbols">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 278,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 275,
   FQN="llvm::MCAssembler::setSubsectionsViaSymbols", NM="_ZN4llvm11MCAssembler24setSubsectionsViaSymbolsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAssembler24setSubsectionsViaSymbolsEb")
  //</editor-fold>
  public void setSubsectionsViaSymbols(boolean Value) {
    SubsectionsViaSymbols = Value;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::isIncrementalLinkerCompatible">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 280,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 277,
   FQN="llvm::MCAssembler::isIncrementalLinkerCompatible", NM="_ZNK4llvm11MCAssembler29isIncrementalLinkerCompatibleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm11MCAssembler29isIncrementalLinkerCompatibleEv")
  //</editor-fold>
  public boolean isIncrementalLinkerCompatible() /*const*/ {
    return IncrementalLinkerCompatible;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::setIncrementalLinkerCompatible">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 283,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 280,
   FQN="llvm::MCAssembler::setIncrementalLinkerCompatible", NM="_ZN4llvm11MCAssembler30setIncrementalLinkerCompatibleEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAssembler30setIncrementalLinkerCompatibleEb")
  //</editor-fold>
  public void setIncrementalLinkerCompatible(boolean Value) {
    IncrementalLinkerCompatible = Value;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::getRelaxAll">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 287,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 284,
   FQN="llvm::MCAssembler::getRelaxAll", NM="_ZNK4llvm11MCAssembler11getRelaxAllEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm11MCAssembler11getRelaxAllEv")
  //</editor-fold>
  public boolean getRelaxAll() /*const*/ {
    return RelaxAll;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::setRelaxAll">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 288,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 285,
   FQN="llvm::MCAssembler::setRelaxAll", NM="_ZN4llvm11MCAssembler11setRelaxAllEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAssembler11setRelaxAllEb")
  //</editor-fold>
  public void setRelaxAll(boolean Value) {
    RelaxAll = Value;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::isBundlingEnabled">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 290,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 287,
   FQN="llvm::MCAssembler::isBundlingEnabled", NM="_ZNK4llvm11MCAssembler17isBundlingEnabledEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm11MCAssembler17isBundlingEnabledEv")
  //</editor-fold>
  public boolean isBundlingEnabled() /*const*/ {
    return BundleAlignSize != 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::getBundleAlignSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 292,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 289,
   FQN="llvm::MCAssembler::getBundleAlignSize", NM="_ZNK4llvm11MCAssembler18getBundleAlignSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm11MCAssembler18getBundleAlignSizeEv")
  //</editor-fold>
  public /*uint*/int getBundleAlignSize() /*const*/ {
    return BundleAlignSize;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::setBundleAlignSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 294,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 291,
   FQN="llvm::MCAssembler::setBundleAlignSize", NM="_ZN4llvm11MCAssembler18setBundleAlignSizeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAssembler18setBundleAlignSizeEj")
  //</editor-fold>
  public void setBundleAlignSize(/*uint*/int Size) {
    assert ((Size == 0 || !((Size & (Size - 1)) != 0))) : "Expect a power-of-two bundle align size";
    BundleAlignSize = Size;
  }

  
  /// \name Section List Access
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 303,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 300,
   FQN="llvm::MCAssembler::begin", NM="_ZN4llvm11MCAssembler5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAssembler5beginEv")
  //</editor-fold>
  public pointee_iterator<MCSection /*P*/ > begin() {
    return new pointee_iterator<MCSection /*P*/ >(Sections.begin());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 304,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 301,
   FQN="llvm::MCAssembler::begin", NM="_ZNK4llvm11MCAssembler5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm11MCAssembler5beginEv")
  //</editor-fold>
  public pointee_iterator</*const*/ MCSection /*P*/ > begin$Const() /*const*/ {
    return new pointee_iterator</*const*/ MCSection /*P*/ >(Sections.begin$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 306,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 303,
   FQN="llvm::MCAssembler::end", NM="_ZN4llvm11MCAssembler3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAssembler3endEv")
  //</editor-fold>
  public pointee_iterator<MCSection /*P*/ > end() {
    return new pointee_iterator<MCSection /*P*/ >(Sections.end());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 307,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 304,
   FQN="llvm::MCAssembler::end", NM="_ZNK4llvm11MCAssembler3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm11MCAssembler3endEv")
  //</editor-fold>
  public pointee_iterator</*const*/ MCSection /*P*/ > end$Const() /*const*/ {
    return new pointee_iterator</*const*/ MCSection /*P*/ >(Sections.end$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 309,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 306,
   FQN="llvm::MCAssembler::size", NM="_ZNK4llvm11MCAssembler4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm11MCAssembler4sizeEv")
  //</editor-fold>
  public /*size_t*/int size() /*const*/ {
    return Sections.size();
  }

  
  /// @}
  /// \name Symbol List Access
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::symbol_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 314,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 311,
   FQN="llvm::MCAssembler::symbol_begin", NM="_ZN4llvm11MCAssembler12symbol_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAssembler12symbol_beginEv")
  //</editor-fold>
  public pointee_iterator</*const*/ MCSymbol /*P*/ > symbol_begin() {
    return new pointee_iterator</*const*/ MCSymbol /*P*/ >(Symbols.begin());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::symbol_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 315,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 312,
   FQN="llvm::MCAssembler::symbol_begin", NM="_ZNK4llvm11MCAssembler12symbol_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm11MCAssembler12symbol_beginEv")
  //</editor-fold>
  public pointee_iterator</*const*/ MCSymbol /*P*/ > symbol_begin$Const() /*const*/ {
    return new pointee_iterator</*const*/ MCSymbol /*P*/ >(Symbols.begin$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::symbol_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 317,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 314,
   FQN="llvm::MCAssembler::symbol_end", NM="_ZN4llvm11MCAssembler10symbol_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAssembler10symbol_endEv")
  //</editor-fold>
  public pointee_iterator</*const*/ MCSymbol /*P*/ > symbol_end() {
    return new pointee_iterator</*const*/ MCSymbol /*P*/ >(Symbols.end());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::symbol_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 318,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 315,
   FQN="llvm::MCAssembler::symbol_end", NM="_ZNK4llvm11MCAssembler10symbol_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm11MCAssembler10symbol_endEv")
  //</editor-fold>
  public pointee_iterator</*const*/ MCSymbol /*P*/ > symbol_end$Const() /*const*/ {
    return new pointee_iterator</*const*/ MCSymbol /*P*/ >(Symbols.end$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::symbols">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 320,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 317,
   FQN="llvm::MCAssembler::symbols", NM="_ZN4llvm11MCAssembler7symbolsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAssembler7symbolsEv")
  //</editor-fold>
  public iterator_range</*const*/ MCSymbol /*&*/ > symbols() {
    return make_range(symbol_begin(), symbol_end());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::symbols">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 321,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 318,
   FQN="llvm::MCAssembler::symbols", NM="_ZNK4llvm11MCAssembler7symbolsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm11MCAssembler7symbolsEv")
  //</editor-fold>
  public iterator_range</*const*/ MCSymbol /*&*/ > symbols$Const() /*const*/ {
    return make_range(symbol_begin$Const(), symbol_end$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::symbol_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 325,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 322,
   FQN="llvm::MCAssembler::symbol_size", NM="_ZNK4llvm11MCAssembler11symbol_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm11MCAssembler11symbol_sizeEv")
  //</editor-fold>
  public /*size_t*/int symbol_size() /*const*/ {
    return Symbols.size();
  }

  
  /// @}
  /// \name Indirect Symbol List Access
  /// @{
  
  // FIXME: This is a total hack, this should not be here. Once things are
  // factored so that the streamer has direct access to the .o writer, it can
  // disappear.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::getIndirectSymbols">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 334,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 331,
   FQN="llvm::MCAssembler::getIndirectSymbols", NM="_ZN4llvm11MCAssembler18getIndirectSymbolsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAssembler18getIndirectSymbolsEv")
  //</editor-fold>
  public std.vector<IndirectSymbolData> /*&*/ getIndirectSymbols() {
    return IndirectSymbols;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::indirect_symbol_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 338,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 335,
   FQN="llvm::MCAssembler::indirect_symbol_begin", NM="_ZN4llvm11MCAssembler21indirect_symbol_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAssembler21indirect_symbol_beginEv")
  //</editor-fold>
  public std.vector.iterator<IndirectSymbolData /*P*/ > indirect_symbol_begin() {
    return IndirectSymbols.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::indirect_symbol_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 341,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 338,
   FQN="llvm::MCAssembler::indirect_symbol_begin", NM="_ZNK4llvm11MCAssembler21indirect_symbol_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm11MCAssembler21indirect_symbol_beginEv")
  //</editor-fold>
  public std.vector.iterator</*const*/ IndirectSymbolData /*P*/ > indirect_symbol_begin$Const() /*const*/ {
    return IndirectSymbols.begin$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::indirect_symbol_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 345,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 342,
   FQN="llvm::MCAssembler::indirect_symbol_end", NM="_ZN4llvm11MCAssembler19indirect_symbol_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAssembler19indirect_symbol_endEv")
  //</editor-fold>
  public std.vector.iterator<IndirectSymbolData /*P*/ > indirect_symbol_end() {
    return IndirectSymbols.end();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::indirect_symbol_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 348,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 345,
   FQN="llvm::MCAssembler::indirect_symbol_end", NM="_ZNK4llvm11MCAssembler19indirect_symbol_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm11MCAssembler19indirect_symbol_endEv")
  //</editor-fold>
  public std.vector.iterator</*const*/ IndirectSymbolData /*P*/ > indirect_symbol_end$Const() /*const*/ {
    return IndirectSymbols.end$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::indirect_symbol_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 352,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 349,
   FQN="llvm::MCAssembler::indirect_symbol_size", NM="_ZNK4llvm11MCAssembler20indirect_symbol_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm11MCAssembler20indirect_symbol_sizeEv")
  //</editor-fold>
  public /*size_t*/int indirect_symbol_size() /*const*/ {
    return IndirectSymbols.size();
  }

  
  /// @}
  /// \name Linker Option List Access
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::getLinkerOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 358,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 355,
   FQN="llvm::MCAssembler::getLinkerOptions", NM="_ZN4llvm11MCAssembler16getLinkerOptionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAssembler16getLinkerOptionsEv")
  //</editor-fold>
  public std.vector<std.vectorString> /*&*/ getLinkerOptions() {
    return LinkerOptions;
  }

  
  /// @}
  /// \name Data Region List Access
  /// @{
  
  // FIXME: This is a total hack, this should not be here. Once things are
  // factored so that the streamer has direct access to the .o writer, it can
  // disappear.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::getDataRegions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 369,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 366,
   FQN="llvm::MCAssembler::getDataRegions", NM="_ZN4llvm11MCAssembler14getDataRegionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAssembler14getDataRegionsEv")
  //</editor-fold>
  public std.vector<DataRegionData> /*&*/ getDataRegions() {
    return DataRegions;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::data_region_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 371,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 368,
   FQN="llvm::MCAssembler::data_region_begin", NM="_ZN4llvm11MCAssembler17data_region_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAssembler17data_region_beginEv")
  //</editor-fold>
  public std.vector.iterator<DataRegionData /*P*/ > data_region_begin() {
    return DataRegions.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::data_region_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 372,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 369,
   FQN="llvm::MCAssembler::data_region_begin", NM="_ZNK4llvm11MCAssembler17data_region_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm11MCAssembler17data_region_beginEv")
  //</editor-fold>
  public std.vector.iterator</*const*/ DataRegionData /*P*/ > data_region_begin$Const() /*const*/ {
    return DataRegions.begin$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::data_region_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 376,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 373,
   FQN="llvm::MCAssembler::data_region_end", NM="_ZN4llvm11MCAssembler15data_region_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAssembler15data_region_endEv")
  //</editor-fold>
  public std.vector.iterator<DataRegionData /*P*/ > data_region_end() {
    return DataRegions.end();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::data_region_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 377,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 374,
   FQN="llvm::MCAssembler::data_region_end", NM="_ZNK4llvm11MCAssembler15data_region_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm11MCAssembler15data_region_endEv")
  //</editor-fold>
  public std.vector.iterator</*const*/ DataRegionData /*P*/ > data_region_end$Const() /*const*/ {
    return DataRegions.end$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::data_region_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 381,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 378,
   FQN="llvm::MCAssembler::data_region_size", NM="_ZNK4llvm11MCAssembler16data_region_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm11MCAssembler16data_region_sizeEv")
  //</editor-fold>
  public /*size_t*/int data_region_size() /*const*/ {
    return DataRegions.size();
  }

  
  /// @}
  /// \name Data Region List Access
  /// @{
  
  // FIXME: This is a total hack, this should not be here. Once things are
  // factored so that the streamer has direct access to the .o writer, it can
  // disappear.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::getLOHContainer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 390,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 387,
   FQN="llvm::MCAssembler::getLOHContainer", NM="_ZN4llvm11MCAssembler15getLOHContainerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAssembler15getLOHContainerEv")
  //</editor-fold>
  public MCLOHContainer /*&*/ getLOHContainer() {
    return LOHContainer;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::getLOHContainer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 391,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 388,
   FQN="llvm::MCAssembler::getLOHContainer", NM="_ZNK4llvm11MCAssembler15getLOHContainerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm11MCAssembler15getLOHContainerEv")
  //</editor-fold>
  public /*const*/ MCLOHContainer /*&*/ getLOHContainer$Const() /*const*/ {
    return ((/*const_cast*/MCAssembler /*P*/ )(this)).getLOHContainer();
  }

  /// @}
  /// \name Backend Data Access
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::registerSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", line = 102,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", old_line = 101,
   FQN="llvm::MCAssembler::registerSection", NM="_ZN4llvm11MCAssembler15registerSectionERNS_9MCSectionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAssembler15registerSectionERNS_9MCSectionE")
  //</editor-fold>
  public boolean registerSection(final MCSection /*&*/ Section) {
    if (Section.isRegistered()) {
      return false;
    }
    Sections.push_back_T$RR($AddrOf(Section));
    Section.setIsRegistered(true);
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::registerSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", line = 378,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", old_line = 373,
   FQN="llvm::MCAssembler::registerSymbol", NM="_ZN4llvm11MCAssembler14registerSymbolERKNS_8MCSymbolEPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAssembler14registerSymbolERKNS_8MCSymbolEPb")
  //</editor-fold>
  public void registerSymbol(final /*const*/ MCSymbol /*&*/ Symbol) {
    registerSymbol(Symbol, (bool$ptr/*bool P*/ )null);
  }
  public void registerSymbol(final /*const*/ MCSymbol /*&*/ Symbol, bool$ptr/*bool P*/ Created/*= null*/) {
    boolean New = !Symbol.isRegistered();
    if (Native.$bool(Created)) {
      Created.$set(New);
    }
    if (New) {
      Symbol.setIsRegistered(true);
      Symbols.push_back_T$RR($AddrOf(Symbol));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::getFileNames">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 402,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 399,
   FQN="llvm::MCAssembler::getFileNames", NM="_ZN4llvm11MCAssembler12getFileNamesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAssembler12getFileNamesEv")
  //</editor-fold>
  public ArrayRef<std.string> getFileNames() {
    return new ArrayRef<std.string>(FileNames, false);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::addFileName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 404,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", old_line = 401,
   FQN="llvm::MCAssembler::addFileName", NM="_ZN4llvm11MCAssembler11addFileNameENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAssembler11addFileNameENS_9StringRefE")
  //</editor-fold>
  public void addFileName(StringRef FileName) {
    if ($eq___normal_iterator$C(std.find(FileNames.begin(), FileNames.end(), FileName), 
        FileNames.end())) {
      FileNames.push_back_T$RR(FileName.$string());
    }
  }

  
  /// \brief Write the necessary bundle padding to the given object writer.
  /// Expects a fragment \p F containing instructions and its size \p FSize.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::writeFragmentPadding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", line = 388,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", old_line = 383,
   FQN="llvm::MCAssembler::writeFragmentPadding", NM="_ZNK4llvm11MCAssembler20writeFragmentPaddingERKNS_10MCFragmentEyPNS_14MCObjectWriterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm11MCAssembler20writeFragmentPaddingERKNS_10MCFragmentEyPNS_14MCObjectWriterE")
  //</editor-fold>
  public void writeFragmentPadding(final /*const*/ MCFragment /*&*/ F, long/*uint64_t*/ FSize, 
                      MCObjectWriter /*P*/ OW) /*const*/ {
    // Should NOP padding be written out before this fragment?
    /*uint*/int BundlePadding = $uchar2uint(F.getBundlePadding());
    if ($greater_uint(BundlePadding, 0)) {
      assert (isBundlingEnabled()) : "Writing bundle padding with disabled bundling";
      assert (F.hasInstructions()) : "Writing bundle padding for a fragment without instructions";
      
      /*uint*/int TotalLength = BundlePadding + ((/*static_cast*//*uint*/int)($ulong2uint(FSize)));
      if (F.alignToBundleEnd() && $greater_uint(TotalLength, getBundleAlignSize())) {
        // If the padding itself crosses a bundle boundary, it must be emitted
        // in 2 pieces, since even nop instructions must not cross boundaries.
        //             v--------------v   <- BundleAlignSize
        //        v---------v             <- BundlePadding
        // ----------------------------
        // | Prev |####|####|    F    |
        // ----------------------------
        //        ^-------------------^   <- TotalLength
        /*uint*/int DistanceToBoundary = TotalLength - getBundleAlignSize();
        if (!getBackend().writeNopData($uint2ulong(DistanceToBoundary), OW)) {
          report_fatal_error(llvm.$add_Twine$C(llvm.$add_Twine$C(new Twine(/*KEEP_STR*/"unable to write NOP sequence of "), 
                      new Twine(JD$UInt.INSTANCE, DistanceToBoundary)), new Twine(/*KEEP_STR*/" bytes")));
        }
        BundlePadding -= DistanceToBoundary;
      }
      if (!getBackend().writeNopData($uint2ulong(BundlePadding), OW)) {
        report_fatal_error(llvm.$add_Twine$C(llvm.$add_Twine$C(new Twine(/*KEEP_STR*/"unable to write NOP sequence of "), 
                    new Twine(JD$UInt.INSTANCE, BundlePadding)), new Twine(/*KEEP_STR*/" bytes")));
      }
    }
  }

  
  /// @}
  
  /// @}
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAssembler::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp", line = 457,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp", old_line = 437,
   FQN="llvm::MCAssembler::dump", NM="_ZN4llvm11MCAssembler4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm11MCAssembler4dumpEv")
  //</editor-fold>
  public void dump()/* __attribute__((used)) __attribute__((noinline))*/ {
    final raw_ostream /*&*/ OS = llvm.errs();
    
    OS.$out(/*KEEP_STR*/"<MCAssembler\n");
    OS.$out(/*KEEP_STR*/"  Sections:[\n    ");
    for (pointee_iterator<MCSection /*P*/ > it = begin(), ie = end(); it.$noteq(ie); it.$preInc()) {
      if (it.$noteq(begin())) {
        OS.$out(/*KEEP_STR*/",\n    ");
      }
      it.$arrow().dump();
    }
    OS.$out(/*KEEP_STR*/"],\n");
    OS.$out(/*KEEP_STR*/"  Symbols:[");
    
    for (pointee_iterator</*const*/ MCSymbol /*P*/ > it = symbol_begin(), ie = symbol_end(); it.$noteq(ie); it.$preInc()) {
      if (it.$noteq(symbol_begin())) {
        OS.$out(/*KEEP_STR*/",\n           ");
      }
      OS.$out(/*KEEP_STR*/$LPAREN);
      it.$arrow().dump();
      OS.$out(/*KEEP_STR*/", Index:").$out_uint(it.$arrow().getIndex()).$out(/*KEEP_STR*/$COMMA_SPACE);
      OS.$out(/*KEEP_STR*/$RPAREN);
    }
    OS.$out(/*KEEP_STR*/"]>\n");
  }


  @Override
  public Iterator<MCSection> iterator() {
    return new JavaIterator<>(Sections.begin(), Sections.end());
  }
  
  @Override public String toString() {
    return "" + "Context=" + "[MCContext]" // NOI18N
              + ", Backend=" + Backend // NOI18N
              + ", Emitter=" + Emitter // NOI18N
              + ", Writer=" + Writer // NOI18N
              + ", Sections=" + Sections // NOI18N
              + ", Symbols=" + Symbols // NOI18N
              + ", IndirectSymbols=" + IndirectSymbols // NOI18N
              + ", DataRegions=" + DataRegions // NOI18N
              + ", LinkerOptions=" + LinkerOptions // NOI18N
              + ", FileNames=" + FileNames // NOI18N
              + ", LTParams=" + LTParams // NOI18N
              + ", ThumbFuncs=" + ThumbFuncs // NOI18N
              + ", BundleAlignSize=" + BundleAlignSize // NOI18N
              + ", RelaxAll=" + RelaxAll // NOI18N
              + ", SubsectionsViaSymbols=" + SubsectionsViaSymbols // NOI18N
              + ", IncrementalLinkerCompatible=" + IncrementalLinkerCompatible // NOI18N
              + ", ELFHeaderEFlags=" + ELFHeaderEFlags // NOI18N
              + ", LOHContainer=" + LOHContainer // NOI18N
              + ", VersionMinInfo=" + VersionMinInfo; // NOI18N
  }
}
