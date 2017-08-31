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
import static org.llvm.mc.impl.MachObjectWriterStatics.ComputeLinkerOptionsLoadCommandSize;

//<editor-fold defaultstate="collapsed" desc="llvm::MachObjectWriter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", line = 74,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", old_line = 75,
 FQN="llvm::MachObjectWriter", NM="_ZN4llvm16MachObjectWriterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZN4llvm16MachObjectWriterE")
//</editor-fold>
public class MachObjectWriter extends /*public*/ MCObjectWriter implements Destructors.ClassWithDestructor {
  /// Helper struct for containing some precomputed information on symbols.
  //<editor-fold defaultstate="collapsed" desc="llvm::MachObjectWriter::MachSymbolData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", line = 76,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", old_line = 77,
   FQN="llvm::MachObjectWriter::MachSymbolData", NM="_ZN4llvm16MachObjectWriter14MachSymbolDataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZN4llvm16MachObjectWriter14MachSymbolDataE")
  //</editor-fold>
  private static class/*struct*/ MachSymbolData implements ComparableLower{
    public /*const*/ MCSymbol /*P*/ Symbol;
    public long/*uint64_t*/ StringIndex;
    public byte/*uint8_t*/ SectionIndex;
    
    // Support lexicographic sorting.
    //<editor-fold defaultstate="collapsed" desc="llvm::MachObjectWriter::MachSymbolData::operator<">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp", line = 55,
     FQN="llvm::MachObjectWriter::MachSymbolData::operator<", NM="_ZNK4llvm16MachObjectWriter14MachSymbolDataltERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZNK4llvm16MachObjectWriter14MachSymbolDataltERKS1_")
    //</editor-fold>
    public boolean $less(final /*const*/ MachSymbolData /*&*/ RHS) /*const*/ {
      return $less_StringRef(Symbol.getName(), RHS.Symbol.getName());
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::MachObjectWriter::MachSymbolData::MachSymbolData">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", line = 76,
     old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", old_line = 77,
     FQN="llvm::MachObjectWriter::MachSymbolData::MachSymbolData", NM="_ZN4llvm16MachObjectWriter14MachSymbolDataC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZN4llvm16MachObjectWriter14MachSymbolDataC1Ev")
    //</editor-fold>
    public /*inline*/ MachSymbolData() {
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::MachObjectWriter::MachSymbolData::MachSymbolData">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", line = 76,
     old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", old_line = 77,
     FQN="llvm::MachObjectWriter::MachSymbolData::MachSymbolData", NM="_ZN4llvm16MachObjectWriter14MachSymbolDataC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZN4llvm16MachObjectWriter14MachSymbolDataC1ERKS1_")
    //</editor-fold>
    public /*inline*/ MachSymbolData(final /*const*/ MachSymbolData /*&*/ $Prm0) {
      // : Symbol(.Symbol), StringIndex(.StringIndex), SectionIndex(.SectionIndex) 
      //START JInit
      this.Symbol = $Prm0.Symbol;
      this.StringIndex = $Prm0.StringIndex;
      this.SectionIndex = $Prm0.SectionIndex;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::MachObjectWriter::MachSymbolData::MachSymbolData">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", line = 76,
     old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", old_line = 77,
     FQN="llvm::MachObjectWriter::MachSymbolData::MachSymbolData", NM="_ZN4llvm16MachObjectWriter14MachSymbolDataC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZN4llvm16MachObjectWriter14MachSymbolDataC1EOS1_")
    //</editor-fold>
    public /*inline*/ MachSymbolData(JD$Move _dparam, final MachSymbolData /*&&*/$Prm0) {
      // : Symbol(static_cast<MachSymbolData &&>().Symbol), StringIndex(static_cast<MachSymbolData &&>().StringIndex), SectionIndex(static_cast<MachSymbolData &&>().SectionIndex) 
      //START JInit
      this.Symbol = $Prm0.Symbol;
      this.StringIndex = $Prm0.StringIndex;
      this.SectionIndex = $Prm0.SectionIndex;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::MachObjectWriter::MachSymbolData::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", line = 76,
     old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", old_line = 77,
     FQN="llvm::MachObjectWriter::MachSymbolData::operator=", NM="_ZN4llvm16MachObjectWriter14MachSymbolDataaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZN4llvm16MachObjectWriter14MachSymbolDataaSEOS1_")
    //</editor-fold>
    public /*inline*/ MachSymbolData /*&*/ $assignMove(final MachSymbolData /*&&*/$Prm0) {
      this.Symbol = $Prm0.Symbol;
      this.StringIndex = $Prm0.StringIndex;
      this.SectionIndex = $Prm0.SectionIndex;
      return /*Deref*/this;
    }

    
    @Override public String toString() {
      return "" + "Symbol=" + Symbol // NOI18N
                + ", StringIndex=" + StringIndex // NOI18N
                + ", SectionIndex=" + $uchar2uint(SectionIndex); // NOI18N
    }

    @Override
    public boolean $less(Object RHS) {
      return this.$less((MachSymbolData)RHS);
    }
  };
  
  /// The target specific Mach-O writer instance.
  private std.unique_ptr<MCMachObjectTargetWriter> TargetObjectWriter;
  
  /// \name Relocation Data
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::MachObjectWriter::RelAndSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", line = 91,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", old_line = 92,
   FQN="llvm::MachObjectWriter::RelAndSymbol", NM="_ZN4llvm16MachObjectWriter12RelAndSymbolE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZN4llvm16MachObjectWriter12RelAndSymbolE")
  //</editor-fold>
  private static class/*struct*/ RelAndSymbol {
    public /*const*/ MCSymbol /*P*/ Sym;
    public MachO.any_relocation_info MRE;
    //<editor-fold defaultstate="collapsed" desc="llvm::MachObjectWriter::RelAndSymbol::RelAndSymbol">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", line = 94,
     old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", old_line = 95,
     FQN="llvm::MachObjectWriter::RelAndSymbol::RelAndSymbol", NM="_ZN4llvm16MachObjectWriter12RelAndSymbolC1EPKNS_8MCSymbolERKNS_5MachO19any_relocation_infoE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZN4llvm16MachObjectWriter12RelAndSymbolC1EPKNS_8MCSymbolERKNS_5MachO19any_relocation_infoE")
    //</editor-fold>
    public RelAndSymbol(/*const*/ MCSymbol /*P*/ Sym, final /*const*/ MachO.any_relocation_info /*&*/ MRE) {
      // : Sym(Sym), MRE(MRE) 
      //START JInit
      this.Sym = Sym;
      this.MRE = new MachO.any_relocation_info(MRE);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::MachObjectWriter::RelAndSymbol::RelAndSymbol">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", line = 91,
     old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", old_line = 92,
     FQN="llvm::MachObjectWriter::RelAndSymbol::RelAndSymbol", NM="_ZN4llvm16MachObjectWriter12RelAndSymbolC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZN4llvm16MachObjectWriter12RelAndSymbolC1ERKS1_")
    //</editor-fold>
    public /*inline*/ RelAndSymbol(final /*const*/ RelAndSymbol /*&*/ $Prm0) {
      // : Sym(.Sym), MRE(.MRE) 
      //START JInit
      this.Sym = $Prm0.Sym;
      this.MRE = new MachO.any_relocation_info($Prm0.MRE);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::MachObjectWriter::RelAndSymbol::RelAndSymbol">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", line = 91,
     old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", old_line = 92,
     FQN="llvm::MachObjectWriter::RelAndSymbol::RelAndSymbol", NM="_ZN4llvm16MachObjectWriter12RelAndSymbolC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZN4llvm16MachObjectWriter12RelAndSymbolC1EOS1_")
    //</editor-fold>
    public /*inline*/ RelAndSymbol(JD$Move _dparam, final RelAndSymbol /*&&*/$Prm0) {
      // : Sym(static_cast<RelAndSymbol &&>().Sym), MRE(static_cast<RelAndSymbol &&>().MRE) 
      //START JInit
      this.Sym = $Prm0.Sym;
      this.MRE = new MachO.any_relocation_info(JD$Move.INSTANCE, $Prm0.MRE);
      //END JInit
    }

    public RelAndSymbol() {
    }

    
    @Override public String toString() {
      return "" + "Sym=" + Sym // NOI18N
                + ", MRE=" + MRE; // NOI18N
    }
  };
  
  private DenseMap</*const*/ MCSection /*P*/ , std.vector<RelAndSymbol>> Relocations;
  private DenseMapTypeUInt</*const*/ MCSection /*P*/ > IndirectSymBase;
  
  private DenseMapTypeULong</*const*/ MCSection /*P*/ > SectionAddress;
  
  /// @}
  /// \name Symbol Table Data
  /// @{
  private StringTableBuilder StringTable/* { StringTableBuilder::MachO }*/;
  private std.vector<MachSymbolData> LocalSymbolData;
  private std.vector<MachSymbolData> ExternalSymbolData;
  private std.vector<MachSymbolData> UndefinedSymbolData;
  
  /// @}
  //<editor-fold defaultstate="collapsed" desc="llvm::MachObjectWriter::findSymbolData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp", line = 297,
   FQN="llvm::MachObjectWriter::findSymbolData", NM="_ZN4llvm16MachObjectWriter14findSymbolDataERKNS_8MCSymbolE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZN4llvm16MachObjectWriter14findSymbolDataERKNS_8MCSymbolE")
  //</editor-fold>
  private MachObjectWriter.MachSymbolData /*P*/ findSymbolData(final /*const*/ MCSymbol /*&*/ Sym) {
    for (std.vector<MachSymbolData/*,default_cls_allocator*/> /*P*/ SymbolData : new std.vector /*P*/ /*const*/ [/*3*/] {$AddrOf(LocalSymbolData), $AddrOf(ExternalSymbolData), $AddrOf(UndefinedSymbolData)})  {
      for (final MachSymbolData /*&*/ Entry : $Deref(SymbolData))  {
        if (Entry.Symbol == $AddrOf(Sym)) {
          return $AddrOf(Entry);
        }
      }
    }
    
    return null;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MachObjectWriter::MachObjectWriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", line = 117,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", old_line = 118,
   FQN="llvm::MachObjectWriter::MachObjectWriter", NM="_ZN4llvm16MachObjectWriterC1EPNS_24MCMachObjectTargetWriterERNS_17raw_pwrite_streamEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZN4llvm16MachObjectWriterC1EPNS_24MCMachObjectTargetWriterERNS_17raw_pwrite_streamEb")
  //</editor-fold>
  public MachObjectWriter(MCMachObjectTargetWriter /*P*/ MOTW, final raw_pwrite_stream /*&*/ OS, 
      boolean IsLittleEndian) {
    // : MCObjectWriter(OS, IsLittleEndian), TargetObjectWriter(MOTW), Relocations(), IndirectSymBase(), SectionAddress(), StringTable(StringTableBuilder::MachO), LocalSymbolData(), ExternalSymbolData(), UndefinedSymbolData() 
    //START JInit
    super(OS, IsLittleEndian);
    this.TargetObjectWriter = new std.unique_ptr<MCMachObjectTargetWriter>(MOTW);
    this.Relocations = new DenseMap</*const*/ MCSection /*P*/ , std.vector<RelAndSymbol>>(DenseMapInfo$LikePtr.$Info(), new std.vector<RelAndSymbol>(new RelAndSymbol()));
    this.IndirectSymBase = new DenseMapTypeUInt</*const*/ MCSection /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    this.SectionAddress = new DenseMapTypeULong</*const*/ MCSection /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    /*InClass*/this.StringTable = /*{ */new StringTableBuilder(StringTableBuilder.Kind.MachO)/* }*/;
    this.LocalSymbolData = new std.vector<MachSymbolData>(new MachSymbolData());
    this.ExternalSymbolData = new std.vector<MachSymbolData>(new MachSymbolData());
    this.UndefinedSymbolData = new std.vector<MachSymbolData>(new MachSymbolData());
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MachObjectWriter::findAliasedSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp", line = 308,
   FQN="llvm::MachObjectWriter::findAliasedSymbol", NM="_ZNK4llvm16MachObjectWriter17findAliasedSymbolERKNS_8MCSymbolE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZNK4llvm16MachObjectWriter17findAliasedSymbolERKNS_8MCSymbolE")
  //</editor-fold>
  public /*const*/ MCSymbol /*&*/ findAliasedSymbol(final /*const*/ MCSymbol /*&*/ Sym) /*const*/ {
    /*const*/ MCSymbol /*P*/ S = $AddrOf(Sym);
    while (S.isVariable()) {
      /*const*/ MCExpr /*P*/ Value = S.getVariableValue();
      /*const*/ MCSymbolRefExpr /*P*/ Ref = dyn_cast_MCSymbolRefExpr(Value);
      if (!(Ref != null)) {
        return $Deref(S);
      }
      S = $AddrOf(Ref.getSymbol());
    }
    return $Deref(S);
  }

  
  /// \name Lifetime management Methods
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::MachObjectWriter::reset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp", line = 31,
   FQN="llvm::MachObjectWriter::reset", NM="_ZN4llvm16MachObjectWriter5resetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZN4llvm16MachObjectWriter5resetEv")
  //</editor-fold>
  @Override public void reset()/* override*/ {
    Relocations.clear();
    IndirectSymBase.clear();
    StringTable.clear();
    LocalSymbolData.clear();
    ExternalSymbolData.clear();
    UndefinedSymbolData.clear();
    super.reset();
  }

  
  /// @}
  
  /// \name Utility Methods
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::MachObjectWriter::isFixupKindPCRel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp", line = 60,
   FQN="llvm::MachObjectWriter::isFixupKindPCRel", NM="_ZN4llvm16MachObjectWriter16isFixupKindPCRelERKNS_11MCAssemblerEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZN4llvm16MachObjectWriter16isFixupKindPCRelERKNS_11MCAssemblerEj")
  //</editor-fold>
  public boolean isFixupKindPCRel(final /*const*/ MCAssembler /*&*/ Asm, /*uint*/int Kind) {
    final /*const*/ MCFixupKindInfo /*&*/ FKI = Asm.getBackend().getFixupKindInfo((/*MCFixupKind*//*uint*/int)Kind);
    
    return ((FKI.Flags & MCFixupKindInfo.FixupKindFlags.FKF_IsPCRel) != 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MachObjectWriter::getSectionAddressMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", line = 135,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", old_line = 136,
   FQN="llvm::MachObjectWriter::getSectionAddressMap", NM="_ZN4llvm16MachObjectWriter20getSectionAddressMapEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZN4llvm16MachObjectWriter20getSectionAddressMapEv")
  //</editor-fold>
  public DenseMapTypeULong</*const*/ MCSection /*P*/ > /*&*/ getSectionAddressMap() {
    return SectionAddress;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MachObjectWriter::getSectionAddress">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", line = 137,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", old_line = 138,
   FQN="llvm::MachObjectWriter::getSectionAddress", NM="_ZNK4llvm16MachObjectWriter17getSectionAddressEPKNS_9MCSectionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZNK4llvm16MachObjectWriter17getSectionAddressEPKNS_9MCSectionE")
  //</editor-fold>
  public long/*uint64_t*/ getSectionAddress(/*const*/ MCSection /*P*/ Sec) /*const*/ {
    return SectionAddress.lookup(Sec);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MachObjectWriter::getSymbolAddress">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp", line = 73,
   FQN="llvm::MachObjectWriter::getSymbolAddress", NM="_ZNK4llvm16MachObjectWriter16getSymbolAddressERKNS_8MCSymbolERKNS_11MCAsmLayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZNK4llvm16MachObjectWriter16getSymbolAddressERKNS_8MCSymbolERKNS_11MCAsmLayoutE")
  //</editor-fold>
  public long/*uint64_t*/ getSymbolAddress(final /*const*/ MCSymbol /*&*/ S, 
                  final /*const*/ MCAsmLayout /*&*/ Layout) /*const*/ {
    // If this is a variable, then recursively evaluate now.
    if (S.isVariable()) {
      {
        /*const*/ MCConstantExpr /*P*/ C = dyn_cast_MCConstantExpr(S.getVariableValue());
        if ((C != null)) {
          return C.getValue();
        }
      }
      
      MCValue Target/*J*/= new MCValue();
      if (!S.getVariableValue().evaluateAsRelocatable(Target, $AddrOf(Layout), (/*const*/ MCFixup /*P*/ )null)) {
        report_fatal_error($add_Twine$C($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"unable to evaluate offset for variable '", 
                    S.getName()), new Twine(/*KEEP_STR*/$SGL_QUOTE)));
      }
      
      // Verify that any used symbols are defined.
      if ((Target.getSymA() != null) && Target.getSymA().getSymbol().isUndefined()) {
        report_fatal_error($add_Twine$C($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"unable to evaluate offset to undefined symbol '", 
                    Target.getSymA().getSymbol().getName()), new Twine(/*KEEP_STR*/$SGL_QUOTE)));
      }
      if ((Target.getSymB() != null) && Target.getSymB().getSymbol().isUndefined()) {
        report_fatal_error($add_Twine$C($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"unable to evaluate offset to undefined symbol '", 
                    Target.getSymB().getSymbol().getName()), new Twine(/*KEEP_STR*/$SGL_QUOTE)));
      }
      
      long/*uint64_t*/ Address = Target.getConstant();
      if ((Target.getSymA() != null)) {
        Address += getSymbolAddress(Target.getSymA().getSymbol(), Layout);
      }
      if ((Target.getSymB() != null)) {
        Address += getSymbolAddress(Target.getSymB().getSymbol(), Layout);
      }
      return Address;
    }
    
    return getSectionAddress(S.getFragment().getParent())
       + Layout.getSymbolOffset(S);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MachObjectWriter::getFragmentAddress">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp", line = 67,
   FQN="llvm::MachObjectWriter::getFragmentAddress", NM="_ZNK4llvm16MachObjectWriter18getFragmentAddressEPKNS_10MCFragmentERKNS_11MCAsmLayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZNK4llvm16MachObjectWriter18getFragmentAddressEPKNS_10MCFragmentERKNS_11MCAsmLayoutE")
  //</editor-fold>
  public long/*uint64_t*/ getFragmentAddress(/*const*/ MCFragment /*P*/ Fragment, 
                    final /*const*/ MCAsmLayout /*&*/ Layout) /*const*/ {
    return getSectionAddress(Fragment.getParent())
       + Layout.getFragmentOffset(Fragment);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MachObjectWriter::getPaddingSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp", line = 106,
   FQN="llvm::MachObjectWriter::getPaddingSize", NM="_ZNK4llvm16MachObjectWriter14getPaddingSizeEPKNS_9MCSectionERKNS_11MCAsmLayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZNK4llvm16MachObjectWriter14getPaddingSizeEPKNS_9MCSectionERKNS_11MCAsmLayoutE")
  //</editor-fold>
  public long/*uint64_t*/ getPaddingSize(/*const*/ MCSection /*P*/ Sec, 
                final /*const*/ MCAsmLayout /*&*/ Layout) /*const*/ {
    long/*uint64_t*/ EndAddr = getSectionAddress(Sec) + Layout.getSectionAddressSize(Sec);
    /*uint*/int Next = Sec.getLayoutOrder() + 1;
    if ($greatereq_uint(Next, Layout.getSectionOrder$Const().size())) {
      return $int2ulong(0);
    }
    
    final /*const*/ MCSection /*&*/ NextSec = $Deref(Layout.getSectionOrder$Const().$at$Const(Next));
    if (NextSec.isVirtualSection()) {
      return $int2ulong(0);
    }
    return OffsetToAlignment(EndAddr, $uint2ulong(NextSec.getAlignment()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MachObjectWriter::doesSymbolRequireExternRelocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp", line = 41,
   FQN="llvm::MachObjectWriter::doesSymbolRequireExternRelocation", NM="_ZN4llvm16MachObjectWriter33doesSymbolRequireExternRelocationERKNS_8MCSymbolE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZN4llvm16MachObjectWriter33doesSymbolRequireExternRelocationERKNS_8MCSymbolE")
  //</editor-fold>
  public boolean doesSymbolRequireExternRelocation(final /*const*/ MCSymbol /*&*/ S) {
    // Undefined symbols are always extern.
    if (S.isUndefined()) {
      return true;
    }
    
    // References to weak definitions require external relocation entries; the
    // definition may not always be the one in the same object file.
    if (cast_MCSymbolMachO(S).isWeakDefinition()) {
      return true;
    }
    
    // Otherwise, we can use an internal relocation.
    return false;
  }

  
  /// @}
  
  /// \name Target Writer Proxy Accessors
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::MachObjectWriter::is64Bit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", line = 154,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", old_line = 155,
   FQN="llvm::MachObjectWriter::is64Bit", NM="_ZNK4llvm16MachObjectWriter7is64BitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZNK4llvm16MachObjectWriter7is64BitEv")
  //</editor-fold>
  public boolean is64Bit() /*const*/ {
    return TargetObjectWriter.$arrow().is64Bit();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MachObjectWriter::isX86_64">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", line = 155,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", old_line = 156,
   FQN="llvm::MachObjectWriter::isX86_64", NM="_ZNK4llvm16MachObjectWriter8isX86_64Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZNK4llvm16MachObjectWriter8isX86_64Ev")
  //</editor-fold>
  public boolean isX86_64() /*const*/ {
    /*uint32_t*/int CPUType = TargetObjectWriter.$arrow().getCPUType();
    return CPUType == MachO.CPUType.CPU_TYPE_X86_64.getValue();
  }

  
  /// @}
  //<editor-fold defaultstate="collapsed" desc="llvm::MachObjectWriter::writeHeader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp", line = 119,
   FQN="llvm::MachObjectWriter::writeHeader", NM="_ZN4llvm16MachObjectWriter11writeHeaderENS_5MachO14HeaderFileTypeEjjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZN4llvm16MachObjectWriter11writeHeaderENS_5MachO14HeaderFileTypeEjjb")
  //</editor-fold>
  public void writeHeader(/*MachO::HeaderFileType*//*uint*/int Type, 
             /*uint*/int NumLoadCommands, 
             /*uint*/int LoadCommandsSize, 
             boolean SubsectionsViaSymbols) {
    /*uint32_t*/int Flags = 0;
    if (SubsectionsViaSymbols) {
      Flags |= MachO.MH_SUBSECTIONS_VIA_SYMBOLS;
    }
    
    // struct mach_header (28 bytes) or
    // struct mach_header_64 (32 bytes)
    long/*uint64_t*/ Start = getStream().tell();
    ///*J:(void)*/Start;
    
    write32(is64Bit() ? MachO.MH_MAGIC_64 : MachO.MH_MAGIC);
    
    write32(TargetObjectWriter.$arrow().getCPUType());
    write32(TargetObjectWriter.$arrow().getCPUSubtype());
    
    write32(Type);
    write32(NumLoadCommands);
    write32(LoadCommandsSize);
    write32(Flags);
    if (is64Bit()) {
      write32(0); // reserved
    }
    assert (getStream().tell() - Start == $uint2ullong((is64Bit() ? MachO.mach_header_64.$sizeof_Mach_header_64() : MachO.mach_header.$sizeof_Mach_header())));
  }

  
  /// Write a segment load command.
  ///
  /// \param NumSections The number of sections in this segment.
  /// \param SectionDataSize The total size of the sections.
  
  /// writeSegmentLoadCommand - Write a segment load command.
  ///
  /// \param NumSections The number of sections in this segment.
  /// \param SectionDataSize The total size of the sections.
  //<editor-fold defaultstate="collapsed" desc="llvm::MachObjectWriter::writeSegmentLoadCommand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp", line = 155,
   FQN="llvm::MachObjectWriter::writeSegmentLoadCommand", NM="_ZN4llvm16MachObjectWriter23writeSegmentLoadCommandENS_9StringRefEjyyyyjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZN4llvm16MachObjectWriter23writeSegmentLoadCommandENS_9StringRefEjyyyyjj")
  //</editor-fold>
  public void writeSegmentLoadCommand(StringRef Name, /*uint*/int NumSections, long/*uint64_t*/ VMAddr, long/*uint64_t*/ VMSize, 
                         long/*uint64_t*/ SectionDataStartOffset, long/*uint64_t*/ SectionDataSize, /*uint32_t*/int MaxProt, 
                         /*uint32_t*/int InitProt) {
    // struct segment_command (56 bytes) or
    // struct segment_command_64 (72 bytes)
    long/*uint64_t*/ Start = getStream().tell();
    ///*J:(void)*/Start;
    
    /*uint*/int SegmentLoadCommandSize = is64Bit() ? MachO.segment_command_64.$sizeof_Segment_command_64() : MachO.segment_command.$sizeof_Segment_command();
    write32(is64Bit() ? MachO.LoadCommandType.LC_SEGMENT_64 : MachO.LoadCommandType.LC_SEGMENT);
    write32(SegmentLoadCommandSize
           + NumSections * (is64Bit() ? MachO.section_64.$sizeof_Section_64() : MachO.section.$sizeof_Section()));
    assert ($lesseq_uint(Name.size(), 16));
    writeBytes(new StringRef(Name), 16);
    if (is64Bit()) {
      write64(VMAddr); // vmaddr
      write64(VMSize); // vmsize
      write64(SectionDataStartOffset); // file offset
      write64(SectionDataSize); // file size
    } else {
      write32($ulong2uint(VMAddr)); // vmaddr
      write32($ulong2uint(VMSize)); // vmsize
      write32($ulong2uint(SectionDataStartOffset)); // file offset
      write32($ulong2uint(SectionDataSize)); // file size
    }
    // maxprot
    write32(MaxProt);
    // initprot
    write32(InitProt);
    write32(NumSections);
    write32(0); // flags
    assert (getStream().tell() - Start == $uint2ullong(SegmentLoadCommandSize));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MachObjectWriter::writeSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp", line = 196,
   FQN="llvm::MachObjectWriter::writeSection", NM="_ZN4llvm16MachObjectWriter12writeSectionERKNS_11MCAsmLayoutERKNS_9MCSectionEyyjyj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZN4llvm16MachObjectWriter12writeSectionERKNS_11MCAsmLayoutERKNS_9MCSectionEyyjyj")
  //</editor-fold>
  public void writeSection(final /*const*/ MCAsmLayout /*&*/ Layout, 
              final /*const*/ MCSection /*&*/ Sec, long/*uint64_t*/ VMAddr, 
              long/*uint64_t*/ FileOffset, /*uint*/int Flags, 
              long/*uint64_t*/ RelocationsStart, 
              /*uint*/int NumRelocations) {
    long/*uint64_t*/ SectionSize = Layout.getSectionAddressSize($AddrOf(Sec));
    final /*const*/ MCSectionMachO /*&*/ Section = cast_MCSectionMachO(Sec);
    
    // The offset is unused for virtual sections.
    if (Section.isVirtualSection()) {
      assert (Layout.getSectionFileSize($AddrOf(Sec)) == $int2ullong(0)) : "Invalid file size!";
      FileOffset = $int2ulong(0);
    }
    
    // struct section (68 bytes) or
    // struct section_64 (80 bytes)
    long/*uint64_t*/ Start = getStream().tell();
    ///*J:(void)*/Start;
    
    writeBytes(Section.getSectionName(), 16);
    writeBytes(Section.getSegmentName(), 16);
    if (is64Bit()) {
      write64(VMAddr); // address
      write64(SectionSize); // size
    } else {
      write32($ulong2uint(VMAddr)); // address
      write32($ulong2uint(SectionSize)); // size
    }
    write32($ulong2uint(FileOffset));
    assert (isPowerOf2_32(Section.getAlignment())) : "Invalid alignment!";
    write32(Log2_32(Section.getAlignment()));
    write32($ullong2uint((NumRelocations != 0) ? RelocationsStart : $int2ullong(0)));
    write32(NumRelocations);
    write32(Flags);
    write32(IndirectSymBase.lookup($AddrOf(Sec))); // reserved1
    write32(Section.getStubSize()); // reserved2
    if (is64Bit()) {
      write32(0); // reserved3
    }
    assert (getStream().tell() - Start == $uint2ullong((is64Bit() ? MachO.section_64.$sizeof_Section_64() : MachO.section.$sizeof_Section())));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MachObjectWriter::writeSymtabLoadCommand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp", line = 241,
   FQN="llvm::MachObjectWriter::writeSymtabLoadCommand", NM="_ZN4llvm16MachObjectWriter22writeSymtabLoadCommandEjjjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZN4llvm16MachObjectWriter22writeSymtabLoadCommandEjjjj")
  //</editor-fold>
  public void writeSymtabLoadCommand(/*uint32_t*/int SymbolOffset, 
                        /*uint32_t*/int NumSymbols, 
                        /*uint32_t*/int StringTableOffset, 
                        /*uint32_t*/int StringTableSize) {
    // struct symtab_command (24 bytes)
    long/*uint64_t*/ Start = getStream().tell();
    ///*J:(void)*/Start;
    
    write32(MachO.LoadCommandType.LC_SYMTAB);
    write32(MachO.symtab_command.$sizeof_Symtab_command());
    write32(SymbolOffset);
    write32(NumSymbols);
    write32(StringTableOffset);
    write32(StringTableSize);
    assert (getStream().tell() - Start == $uint2ullong(MachO.symtab_command.$sizeof_Symtab_command()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MachObjectWriter::writeDysymtabLoadCommand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp", line = 260,
   FQN="llvm::MachObjectWriter::writeDysymtabLoadCommand", NM="_ZN4llvm16MachObjectWriter24writeDysymtabLoadCommandEjjjjjjjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZN4llvm16MachObjectWriter24writeDysymtabLoadCommandEjjjjjjjj")
  //</editor-fold>
  public void writeDysymtabLoadCommand(/*uint32_t*/int FirstLocalSymbol, 
                          /*uint32_t*/int NumLocalSymbols, 
                          /*uint32_t*/int FirstExternalSymbol, 
                          /*uint32_t*/int NumExternalSymbols, 
                          /*uint32_t*/int FirstUndefinedSymbol, 
                          /*uint32_t*/int NumUndefinedSymbols, 
                          /*uint32_t*/int IndirectSymbolOffset, 
                          /*uint32_t*/int NumIndirectSymbols) {
    // struct dysymtab_command (80 bytes)
    long/*uint64_t*/ Start = getStream().tell();
    ///*J:(void)*/Start;
    
    write32(MachO.LoadCommandType.LC_DYSYMTAB);
    write32(MachO.dysymtab_command.$sizeof_Dysymtab_command());
    write32(FirstLocalSymbol);
    write32(NumLocalSymbols);
    write32(FirstExternalSymbol);
    write32(NumExternalSymbols);
    write32(FirstUndefinedSymbol);
    write32(NumUndefinedSymbols);
    write32(0); // tocoff
    write32(0); // ntoc
    write32(0); // modtaboff
    write32(0); // nmodtab
    write32(0); // extrefsymoff
    write32(0); // nextrefsyms
    write32(IndirectSymbolOffset);
    write32(NumIndirectSymbols);
    write32(0); // extreloff
    write32(0); // nextrel
    write32(0); // locreloff
    write32(0); // nlocrel
    assert (getStream().tell() - Start == $uint2ullong(MachO.dysymtab_command.$sizeof_Dysymtab_command()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MachObjectWriter::writeNlist">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp", line = 320,
   FQN="llvm::MachObjectWriter::writeNlist", NM="_ZN4llvm16MachObjectWriter10writeNlistERNS0_14MachSymbolDataERKNS_11MCAsmLayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZN4llvm16MachObjectWriter10writeNlistERNS0_14MachSymbolDataERKNS_11MCAsmLayoutE")
  //</editor-fold>
  public void writeNlist(final MachSymbolData /*&*/ MSD, 
            final /*const*/ MCAsmLayout /*&*/ Layout) {
    /*const*/ MCSymbol /*P*/ Symbol = MSD.Symbol;
    final /*const*/ MCSymbol /*&*/ Data = $Deref(Symbol);
    /*const*/ MCSymbol /*P*/ AliasedSymbol = $AddrOf(findAliasedSymbol($Deref(Symbol)));
    byte/*uint8_t*/ SectionIndex = MSD.SectionIndex;
    byte/*uint8_t*/ Type = $int2uchar(0);
    long/*uint64_t*/ Address = $int2ulong(0);
    boolean IsAlias = Symbol != AliasedSymbol;
    
    final /*const*/ MCSymbol /*&*/ OrigSymbol = $Deref(Symbol);
    MachSymbolData /*P*/ AliaseeInfo = new MachSymbolData();
    if (IsAlias) {
      AliaseeInfo = findSymbolData($Deref(AliasedSymbol));
      if ((AliaseeInfo != null)) {
        SectionIndex = AliaseeInfo.SectionIndex;
      }
      Symbol = AliasedSymbol;
      // FIXME: Should this update Data as well?
    }
    
    // Set the N_TYPE bits. See <mach-o/nlist.h>.
    //
    // FIXME: Are the prebound or indirect fields possible here?
    if (IsAlias && Symbol.isUndefined()) {
      Type = $uint2uchar(MachO.NListType.N_INDR);
    } else if (Symbol.isUndefined()) {
      Type = $uint2uchar(MachO.NListType.N_UNDF);
    } else if (Symbol.isAbsolute()) {
      Type = $uint2uchar(MachO.NListType.N_ABS);
    } else {
      Type = $uint2uchar(MachO.NListType.N_SECT);
    }
    
    // FIXME: Set STAB bits.
    if (Data.isPrivateExtern()) {
      Type |= MachO.N_PEXT;
    }
    
    // Set external bit.
    if (Data.isExternal() || (!IsAlias && Symbol.isUndefined())) {
      Type |= MachO.N_EXT;
    }
    
    // Compute the symbol address.
    if (IsAlias && Symbol.isUndefined()) {
      Address = AliaseeInfo.StringIndex;
    } else if (Symbol.isDefined()) {
      Address = getSymbolAddress(OrigSymbol, Layout);
    } else if (Symbol.isCommon()) {
      // Common symbols are encoded with the size in the address
      // field, and their alignment in the flags.
      Address = Symbol.getCommonSize();
    }
    
    // struct nlist (12 bytes)
    write32($ulong2uint(MSD.StringIndex));
    write8(Type);
    write8(SectionIndex);
    
    // The Mach-O streamer uses the lowest 16-bits of the flags for the 'desc'
    // value.
    boolean EncodeAsAltEntry = IsAlias && cast_MCSymbolMachO(OrigSymbol).isAltEntry();
    write16(cast_MCSymbolMachO(Symbol).getEncodedFlags(EncodeAsAltEntry));
    if (is64Bit()) {
      write64(Address);
    } else {
      write32($ulong2uint(Address));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MachObjectWriter::writeLinkeditLoadCommand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp", line = 389,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp", old_line = 387,
   FQN="llvm::MachObjectWriter::writeLinkeditLoadCommand", NM="_ZN4llvm16MachObjectWriter24writeLinkeditLoadCommandEjjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZN4llvm16MachObjectWriter24writeLinkeditLoadCommandEjjj")
  //</editor-fold>
  public void writeLinkeditLoadCommand(/*uint32_t*/int Type, 
                          /*uint32_t*/int DataOffset, 
                          /*uint32_t*/int DataSize) {
    long/*uint64_t*/ Start = getStream().tell();
    ///*J:(void)*/Start;
    
    write32(Type);
    write32(MachO.linkedit_data_command.$sizeof_Linkedit_data_command());
    write32(DataOffset);
    write32(DataSize);
    assert (getStream().tell() - Start == $uint2ullong(MachO.linkedit_data_command.$sizeof_Linkedit_data_command()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MachObjectWriter::writeLinkerOptionsLoadCommand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp", line = 412,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp", old_line = 410,
   FQN="llvm::MachObjectWriter::writeLinkerOptionsLoadCommand", NM="_ZN4llvm16MachObjectWriter29writeLinkerOptionsLoadCommandERKSt6vectorISsSaISsEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZN4llvm16MachObjectWriter29writeLinkerOptionsLoadCommandERKSt6vectorISsSaISsEE")
  //</editor-fold>
  public void writeLinkerOptionsLoadCommand(final /*const*/std.vectorString/*&*/ Options) {
    /*uint*/int Size = ComputeLinkerOptionsLoadCommandSize(Options, is64Bit());
    long/*uint64_t*/ Start = getStream().tell();
    ///*J:(void)*/Start;
    
    write32(MachO.LoadCommandType.LC_LINKER_OPTION);
    write32(Size);
    write32(Options.size());
    long/*uint64_t*/ BytesWritten = $uint2ulong(MachO.linker_option_command.$sizeof_Linker_option_command());
    for (final /*const*/std.string/*&*/ Option : Options) {
      // Write each string, including the null byte.
      writeBytes(new StringRef(Option.c_str()), Option.size() + 1);
      BytesWritten += $uint2ullong(Option.size() + 1);
    }
    
    // Pad to a multiple of the pointer size.
    writeBytes(new StringRef(/*KEEP_STR*/$EMPTY), $ulong2uint(OffsetToAlignment(BytesWritten, $int2ulong(is64Bit() ? 8 : 4))));
    assert (getStream().tell() - Start == $uint2ullong(Size));
  }

  
  // FIXME: We really need to improve the relocation validation. Basically, we
  // want to implement a separate computation which evaluates the relocation
  // entry as the linker would, and verifies that the resultant fixup value is
  // exactly what the encoder wanted. This will catch several classes of
  // problems:
  //
  //  - Relocation entry bugs, the two algorithms are unlikely to have the same
  //    exact bug.
  //
  //  - Relaxation issues, where we forget to relax something.
  //
  //  - Input errors, where something cannot be correctly encoded. 'as' allows
  //    these through in many cases.
  
  // Add a relocation to be output in the object file. At the time this is
  // called, the symbol indexes are not know, so if the relocation refers
  // to a symbol it should be passed as \p RelSymbol so that it can be updated
  // afterwards. If the relocation doesn't refer to a symbol, nullptr should be
  // used.
  //<editor-fold defaultstate="collapsed" desc="llvm::MachObjectWriter::addRelocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", line = 215,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", old_line = 216,
   FQN="llvm::MachObjectWriter::addRelocation", NM="_ZN4llvm16MachObjectWriter13addRelocationEPKNS_8MCSymbolEPKNS_9MCSectionERNS_5MachO19any_relocation_infoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZN4llvm16MachObjectWriter13addRelocationEPKNS_8MCSymbolEPKNS_9MCSectionERNS_5MachO19any_relocation_infoE")
  //</editor-fold>
  public void addRelocation(/*const*/ MCSymbol /*P*/ RelSymbol, /*const*/ MCSection /*P*/ Sec, 
               final MachO.any_relocation_info /*&*/ MRE) {
    RelAndSymbol P/*J*/= new RelAndSymbol(RelSymbol, MRE);
    Relocations.$at_T1$C$R(Sec).push_back_T$C$R(P);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MachObjectWriter::recordScatteredRelocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", line = 221,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", old_line = 222,
   FQN="llvm::MachObjectWriter::recordScatteredRelocation", NM="_ZN4llvm16MachObjectWriter25recordScatteredRelocationERKNS_11MCAssemblerERKNS_11MCAsmLayoutEPKNS_10MCFragmentERKNS_7MCFixupENS_7MCValueEjRy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZN4llvm16MachObjectWriter25recordScatteredRelocationERKNS_11MCAssemblerERKNS_11MCAsmLayoutEPKNS_10MCFragmentERKNS_7MCFixupENS_7MCValueEjRy")
  //</editor-fold>
  public void recordScatteredRelocation(final /*const*/ MCAssembler /*&*/ Asm, 
                           final /*const*/ MCAsmLayout /*&*/ Layout, 
                           /*const*/ MCFragment /*P*/ Fragment, 
                           final /*const*/ MCFixup /*&*/ Fixup, MCValue Target, 
                           /*uint*/int Log2Size, final ulong$ref/*uint64_t &*/ FixedValue) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::MachObjectWriter::recordTLVPRelocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", line = 227,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", old_line = 228,
   FQN="llvm::MachObjectWriter::recordTLVPRelocation", NM="_ZN4llvm16MachObjectWriter20recordTLVPRelocationERKNS_11MCAssemblerERKNS_11MCAsmLayoutEPKNS_10MCFragmentERKNS_7MCFixupENS_7MCValueERy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZN4llvm16MachObjectWriter20recordTLVPRelocationERKNS_11MCAssemblerERKNS_11MCAsmLayoutEPKNS_10MCFragmentERKNS_7MCFixupENS_7MCValueERy")
  //</editor-fold>
  public void recordTLVPRelocation(final /*const*/ MCAssembler /*&*/ Asm, final /*const*/ MCAsmLayout /*&*/ Layout, 
                      /*const*/ MCFragment /*P*/ Fragment, final /*const*/ MCFixup /*&*/ Fixup, 
                      MCValue Target, final ulong$ref/*uint64_t &*/ FixedValue) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::MachObjectWriter::recordRelocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp", line = 435,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp", old_line = 433,
   FQN="llvm::MachObjectWriter::recordRelocation", NM="_ZN4llvm16MachObjectWriter16recordRelocationERNS_11MCAssemblerERKNS_11MCAsmLayoutEPKNS_10MCFragmentERKNS_7MCFixupENS_7MCValueERbRy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZN4llvm16MachObjectWriter16recordRelocationERNS_11MCAssemblerERKNS_11MCAsmLayoutEPKNS_10MCFragmentERKNS_7MCFixupENS_7MCValueERbRy")
  //</editor-fold>
  @Override public void recordRelocation(final MCAssembler /*&*/ Asm, 
                  final /*const*/ MCAsmLayout /*&*/ Layout, 
                  /*const*/ MCFragment /*P*/ Fragment, 
                  final /*const*/ MCFixup /*&*/ Fixup, MCValue Target, 
                  final bool$ref/*bool &*/ IsPCRel, final ulong$ref/*uint64_t &*/ FixedValue)/* override*/ {
    TargetObjectWriter.$arrow().recordRelocation(this, Asm, Layout, Fragment, Fixup, 
        new MCValue(Target), FixedValue);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MachObjectWriter::bindIndirectSymbols">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp", line = 444,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp", old_line = 442,
   FQN="llvm::MachObjectWriter::bindIndirectSymbols", NM="_ZN4llvm16MachObjectWriter19bindIndirectSymbolsERNS_11MCAssemblerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZN4llvm16MachObjectWriter19bindIndirectSymbolsERNS_11MCAssemblerE")
  //</editor-fold>
  public void bindIndirectSymbols(final MCAssembler /*&*/ Asm) {
    // This is the point where 'as' creates actual symbols for indirect symbols
    // (in the following two passes). It would be easier for us to do this sooner
    // when we see the attribute, but that makes getting the order in the symbol
    // table much more complicated than it is worth.
    //
    // FIXME: Revisit this when the dust settles.
    
    // Report errors for use of .indirect_symbol not in a symbol pointer section
    // or stub section.
    for (std.vector.iterator<IndirectSymbolData /*P*/ > it = Asm.indirect_symbol_begin(), 
        ie = Asm.indirect_symbol_end(); $noteq___normal_iterator$C(it, ie); it.$preInc()) {
      final /*const*/ MCSectionMachO /*&*/ Section = cast_MCSectionMachO($Deref(it.$arrow().Section));
      if (Section.getType() != MachO.SectionType.S_NON_LAZY_SYMBOL_POINTERS
         && Section.getType() != MachO.SectionType.S_LAZY_SYMBOL_POINTERS
         && Section.getType() != MachO.SectionType.S_THREAD_LOCAL_VARIABLE_POINTERS
         && Section.getType() != MachO.SectionType.S_SYMBOL_STUBS) {
        final MCSymbol /*&*/ Symbol = $Deref(it.$arrow().Symbol);
        report_fatal_error($add_Twine$C($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"indirect symbol '", Symbol.getName()), 
                new Twine(/*KEEP_STR*/"' not in a symbol pointer or stub section")));
      }
    }
    
    // Bind non-lazy symbol pointers first.
    /*uint*/int IndirectIndex = 0;
    for (std.vector.iterator<IndirectSymbolData /*P*/ > it = Asm.indirect_symbol_begin(), 
        ie = Asm.indirect_symbol_end(); $noteq___normal_iterator$C(it, ie); it.$preInc() , ++IndirectIndex) {
      final /*const*/ MCSectionMachO /*&*/ Section = cast_MCSectionMachO($Deref(it.$arrow().Section));
      if (Section.getType() != MachO.SectionType.S_NON_LAZY_SYMBOL_POINTERS
         && Section.getType() != MachO.SectionType.S_THREAD_LOCAL_VARIABLE_POINTERS) {
        continue;
      }
      
      // Initialize the section indirect symbol base, if necessary.
      IndirectSymBase.insert_pair$KeyT$ValueT(new std.pairPtrUInt</*const*/ MCSection /*P*/ >(JD$Pair$_U1$_U2.INSTANCE, /*Fwd2*//*Fwd*/it.$arrow().Section, /*Fwd2*//*Fwd*/IndirectIndex));
      
      Asm.registerSymbol($Deref(it.$arrow().Symbol));
    }
    
    // Then lazy symbol pointers and symbol stubs.
    IndirectIndex = 0;
    for (std.vector.iterator<IndirectSymbolData /*P*/ > it = Asm.indirect_symbol_begin(), 
        ie = Asm.indirect_symbol_end(); $noteq___normal_iterator$C(it, ie); it.$preInc() , ++IndirectIndex) {
      final /*const*/ MCSectionMachO /*&*/ Section = cast_MCSectionMachO($Deref(it.$arrow().Section));
      if (Section.getType() != MachO.SectionType.S_LAZY_SYMBOL_POINTERS
         && Section.getType() != MachO.SectionType.S_SYMBOL_STUBS) {
        continue;
      }
      
      // Initialize the section indirect symbol base, if necessary.
      IndirectSymBase.insert_pair$KeyT$ValueT(
              new std.pairPtrUInt</*const*/ MCSection /*P*/ >(
                      JD$Pair$_U1$_U2.INSTANCE, /*Fwd2*//*Fwd*/it.$arrow().Section, /*Fwd2*//*Fwd*/IndirectIndex));
      
      // Set the symbol type to undefined lazy, but only on construction.
      //
      // FIXME: Do not hardcode.
      bool$ptr Created = create_bool$ptr();
      Asm.registerSymbol($Deref(it.$arrow().Symbol), $AddrOf(Created));
      if (Created.$star()) {
        cast_MCSymbolMachO(it.$arrow().Symbol).setReferenceTypeUndefinedLazy(true);
      }
    }
  }

  
  /// Compute the symbol table data.
  
  /// computeSymbolTable - Compute the symbol table data
  //<editor-fold defaultstate="collapsed" desc="llvm::MachObjectWriter::computeSymbolTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp", line = 508,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp", old_line = 504,
   FQN="llvm::MachObjectWriter::computeSymbolTable", NM="_ZN4llvm16MachObjectWriter18computeSymbolTableERNS_11MCAssemblerERSt6vectorINS0_14MachSymbolDataESaIS4_EES7_S7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZN4llvm16MachObjectWriter18computeSymbolTableERNS_11MCAssemblerERSt6vectorINS0_14MachSymbolDataESaIS4_EES7_S7_")
  //</editor-fold>
  public void computeSymbolTable(final MCAssembler /*&*/ Asm, final std.vector<MachSymbolData> /*&*/ LocalSymbolData, 
                    final std.vector<MachSymbolData> /*&*/ ExternalSymbolData, 
                    final std.vector<MachSymbolData> /*&*/ UndefinedSymbolData) {
    // Build section lookup table.
    DenseMapTypeUChar</*const*/ MCSection /*P*/ > SectionIndexMap/*J*/= new DenseMapTypeUChar</*const*/ MCSection /*P*/ >(DenseMapInfo$LikePtr.$Info(), (byte)0);
    /*uint*/int Index = 1;
    for (pointee_iterator<MCSection /*P*/ > it = Asm.begin(), 
        ie = Asm.end(); it.$noteq(ie); it.$preInc() , ++Index)  {
      SectionIndexMap.$set($AddrOf(it.$star()), $uint2uchar(Index));
    }
    assert ($lesseq_uint(Index, 256)) : "Too many sections!";
    
    // Build the string table.
    for (final /*const*/ MCSymbol /*&*/ Symbol : Asm.symbols()) {
      if (!Asm.isSymbolLinkerVisible(Symbol)) {
        continue;
      }
      
      StringTable.add(Symbol.getName());
    }
    StringTable.finalize();
    
    // Build the symbol arrays but only for non-local symbols.
    //
    // The particular order that we collect and then sort the symbols is chosen to
    // match 'as'. Even though it doesn't matter for correctness, this is
    // important for letting us diff .o files.
    for (final /*const*/ MCSymbol /*&*/ Symbol : Asm.symbols()) {
      // Ignore non-linker visible symbols.
      if (!Asm.isSymbolLinkerVisible(Symbol)) {
        continue;
      }
      if (!Symbol.isExternal() && !Symbol.isUndefined()) {
        continue;
      }
      
      MachSymbolData MSD/*J*/= new MachSymbolData();
      MSD.Symbol = $AddrOf(Symbol);
      MSD.StringIndex = $uint2ulong(StringTable.getOffset(Symbol.getName()));
      if (Symbol.isUndefined()) {
        MSD.SectionIndex = $int2uchar(0);
        UndefinedSymbolData.push_back_T$C$R(MSD);
      } else if (Symbol.isAbsolute()) {
        MSD.SectionIndex = $int2uchar(0);
        ExternalSymbolData.push_back_T$C$R(MSD);
      } else {
        MSD.SectionIndex = SectionIndexMap.lookup($AddrOf(Symbol.getSection()));
        assert ((MSD.SectionIndex != 0)) : "Invalid section index!";
        ExternalSymbolData.push_back_T$C$R(MSD);
      }
    }
    
    // Now add the data for local symbols.
    for (final /*const*/ MCSymbol /*&*/ Symbol : Asm.symbols()) {
      // Ignore non-linker visible symbols.
      if (!Asm.isSymbolLinkerVisible(Symbol)) {
        continue;
      }
      if (Symbol.isExternal() || Symbol.isUndefined()) {
        continue;
      }
      
      MachSymbolData MSD/*J*/= new MachSymbolData();
      MSD.Symbol = $AddrOf(Symbol);
      MSD.StringIndex = $uint2ulong(StringTable.getOffset(Symbol.getName()));
      if (Symbol.isAbsolute()) {
        MSD.SectionIndex = $int2uchar(0);
        LocalSymbolData.push_back_T$C$R(MSD);
      } else {
        MSD.SectionIndex = SectionIndexMap.lookup($AddrOf(Symbol.getSection()));
        assert ((MSD.SectionIndex != 0)) : "Invalid section index!";
        LocalSymbolData.push_back_T$C$R(MSD);
      }
    }
    
    // External and undefined symbols are required to be in lexicographic order.
    std.sort(ExternalSymbolData.begin(), ExternalSymbolData.end());
    std.sort(UndefinedSymbolData.begin(), UndefinedSymbolData.end());
    
    // Set the symbol indices.
    Index = 0;
    for (std.vector<MachSymbolData/*,default_cls_allocator*/> /*P*/ SymbolData : new std.vector /*P*/ /*const*/ [/*3*/] {$AddrOf(LocalSymbolData), $AddrOf(ExternalSymbolData), $AddrOf(UndefinedSymbolData)})  {
      for (final MachSymbolData /*&*/ Entry : $Deref(SymbolData))  {
        Entry.Symbol.setIndex(Index++);
      }
    }
    
    for (final /*const*/ MCSection /*&*/ Section : Asm) {
      for (final RelAndSymbol /*&*/ Rel : Relocations.$at_T1$RR($AddrOf(Section))) {
        if (!(Rel.Sym != null)) {
          continue;
        }
        
        // Set the Index and the IsExtern bit.
        /*uint*/int Index$1 = Rel.Sym.getIndex();
        assert (isInt($uint2long(Index$1), 24));
        if (IsLittleEndian) {
          Rel.MRE.r_word1 = (Rel.MRE.r_word1 & (~0/*U*/ << 24)) | Index$1 | (1 << 27);
        } else {
          Rel.MRE.r_word1 = (Rel.MRE.r_word1 & 0xff) | Index$1 << 8 | (1 << 4);
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MachObjectWriter::computeSectionAddresses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp", line = 609,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp", old_line = 605,
   FQN="llvm::MachObjectWriter::computeSectionAddresses", NM="_ZN4llvm16MachObjectWriter23computeSectionAddressesERKNS_11MCAssemblerERKNS_11MCAsmLayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZN4llvm16MachObjectWriter23computeSectionAddressesERKNS_11MCAssemblerERKNS_11MCAsmLayoutE")
  //</editor-fold>
  public void computeSectionAddresses(final /*const*/ MCAssembler /*&*/ Asm, 
                         final /*const*/ MCAsmLayout /*&*/ Layout) {
    long/*uint64_t*/ StartAddress = $int2ulong(0);
    for (/*const*/ MCSection /*P*/ Sec : Layout.getSectionOrder$Const()) {
      StartAddress = alignTo(StartAddress, $uint2ulong(Sec.getAlignment()));
      SectionAddress.$set(Sec, StartAddress);
      StartAddress += Layout.getSectionAddressSize(Sec);
      
      // Explicitly pad the section to match the alignment requirements of the
      // following one. This is for 'gas' compatibility, it shouldn't
      /// strictly be necessary.
      StartAddress += getPaddingSize(Sec, Layout);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MachObjectWriter::executePostLayoutBinding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp", line = 624,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp", old_line = 620,
   FQN="llvm::MachObjectWriter::executePostLayoutBinding", NM="_ZN4llvm16MachObjectWriter24executePostLayoutBindingERNS_11MCAssemblerERKNS_11MCAsmLayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZN4llvm16MachObjectWriter24executePostLayoutBindingERNS_11MCAssemblerERKNS_11MCAsmLayoutE")
  //</editor-fold>
  @Override public void executePostLayoutBinding(final MCAssembler /*&*/ Asm, 
                          final /*const*/ MCAsmLayout /*&*/ Layout)/* override*/ {
    computeSectionAddresses(Asm, Layout);
    
    // Create symbol data for any indirect symbols.
    bindIndirectSymbols(Asm);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MachObjectWriter::isSymbolRefDifferenceFullyResolvedImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp", line = 632,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp", old_line = 628,
   FQN="llvm::MachObjectWriter::isSymbolRefDifferenceFullyResolvedImpl", NM="_ZNK4llvm16MachObjectWriter38isSymbolRefDifferenceFullyResolvedImplERKNS_11MCAssemblerERKNS_8MCSymbolES6_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZNK4llvm16MachObjectWriter38isSymbolRefDifferenceFullyResolvedImplERKNS_11MCAssemblerERKNS_8MCSymbolES6_b")
  //</editor-fold>
  @Override public boolean isSymbolRefDifferenceFullyResolvedImpl(final /*const*/ MCAssembler /*&*/ Asm, final /*const*/ MCSymbol /*&*/ A, final /*const*/ MCSymbol /*&*/ B, 
                                        boolean InSet) /*const*//* override*/ {
    // FIXME: We don't handle things like
    // foo = .
    // creating atoms.
    if (A.isVariable() || B.isVariable()) {
      return false;
    }
    return super.isSymbolRefDifferenceFullyResolvedImpl(Asm, A, B, 
        InSet);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MachObjectWriter::isSymbolRefDifferenceFullyResolvedImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp", line = 644,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp", old_line = 640,
   FQN="llvm::MachObjectWriter::isSymbolRefDifferenceFullyResolvedImpl", NM="_ZNK4llvm16MachObjectWriter38isSymbolRefDifferenceFullyResolvedImplERKNS_11MCAssemblerERKNS_8MCSymbolERKNS_10MCFragmentEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZNK4llvm16MachObjectWriter38isSymbolRefDifferenceFullyResolvedImplERKNS_11MCAssemblerERKNS_8MCSymbolERKNS_10MCFragmentEbb")
  //</editor-fold>
  @Override public boolean isSymbolRefDifferenceFullyResolvedImpl(final /*const*/ MCAssembler /*&*/ Asm, final /*const*/ MCSymbol /*&*/ SymA, final /*const*/ MCFragment /*&*/ FB, 
                                        boolean InSet, boolean IsPCRel) /*const*//* override*/ {
    if (InSet) {
      return true;
    }
    
    // The effective address is
    //     addr(atom(A)) + offset(A)
    //   - addr(atom(B)) - offset(B)
    // and the offsets are not relocatable, so the fixup is fully resolved when
    //  addr(atom(A)) - addr(atom(B)) == 0.
    final /*const*/ MCSymbol /*&*/ SA = findAliasedSymbol(SymA);
    final /*const*/ MCSection /*&*/ SecA = SA.getSection();
    final /*const*/ MCSection /*&*/ SecB = $Deref(FB.getParent());
    if (IsPCRel) {
      // The simple (Darwin, except on x86_64) way of dealing with this was to
      // assume that any reference to a temporary symbol *must* be a temporary
      // symbol in the same atom, unless the sections differ. Therefore, any PCrel
      // relocation to a temporary symbol (in the same section) is fully
      // resolved. This also works in conjunction with absolutized .set, which
      // requires the compiler to use .set to absolutize the differences between
      // symbols which the compiler knows to be assembly time constants, so we
      // don't need to worry about considering symbol differences fully resolved.
      //
      // If the file isn't using sub-sections-via-symbols, we can make the
      // same assumptions about any symbol that we normally make about
      // assembler locals.
      boolean hasReliableSymbolDifference = isX86_64();
      if (!hasReliableSymbolDifference) {
        if (!SA.isInSection() || $AddrOf(SecA) != $AddrOf(SecB)
           || (!SA.isTemporary() && FB.getAtom() != SA.getFragment().getAtom()
           && Asm.getSubsectionsViaSymbols())) {
          return false;
        }
        return true;
      } else // For Darwin x86_64, there is one special case when the reference IsPCRel.
      // If the fragment with the reference does not have a base symbol but meets
      // the simple way of dealing with this, in that it is a temporary symbol in
      // the same atom then it is assumed to be fully resolved.  This is needed so
      // a relocation entry is not created and so the static linker does not
      // mess up the reference later.
      if (!(FB.getAtom() != null)
         && SA.isTemporary() && SA.isInSection() && $AddrOf(SecA) == $AddrOf(SecB)) {
        return true;
      }
    }
    
    // If they are not in the same section, we can't compute the diff.
    if ($AddrOf(SecA) != $AddrOf(SecB)) {
      return false;
    }
    
    /*const*/ MCFragment /*P*/ FA = SA.getFragment();
    
    // Bail if the symbol has no fragment.
    if (!(FA != null)) {
      return false;
    }
    
    // If the atoms are the same, they are guaranteed to have the same address.
    if (FA.getAtom() == FB.getAtom()) {
      return true;
    }
    
    // Otherwise, we can't prove this is fully resolved.
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MachObjectWriter::writeObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp", line = 711,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp", old_line = 707,
   FQN="llvm::MachObjectWriter::writeObject", NM="_ZN4llvm16MachObjectWriter11writeObjectERNS_11MCAssemblerERKNS_11MCAsmLayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZN4llvm16MachObjectWriter11writeObjectERNS_11MCAssemblerERKNS_11MCAsmLayoutE")
  //</editor-fold>
  @Override public void writeObject(final MCAssembler /*&*/ Asm, 
             final /*const*/ MCAsmLayout /*&*/ Layout)/* override*/ {
    // Compute symbol table information and bind symbol indices.
    computeSymbolTable(Asm, LocalSymbolData, ExternalSymbolData, 
        UndefinedSymbolData);
    
    /*uint*/int NumSections = Asm.size();
    final /*const*/  MCAssembler.VersionMinInfoType /*&*/ VersionInfo = Layout.getAssembler().getVersionMinInfo();
    
    // The section data starts after the header, the segment load command (and
    // section headers) and the symbol table.
    /*uint*/int NumLoadCommands = 1;
    long/*uint64_t*/ LoadCommandsSize = $uint2ulong(is64Bit() ? MachO.segment_command_64.$sizeof_Segment_command_64() + NumSections * MachO.section_64.$sizeof_Section_64() :
            MachO.segment_command.$sizeof_Segment_command() + NumSections * MachO.section.$sizeof_Section());
    
    // Add the deployment target version info load command size, if used.
    if (VersionInfo.Major != 0) {
      ++NumLoadCommands;
      LoadCommandsSize += $uint2ullong(MachO.version_min_command.$sizeof_Version_min_command());
    }
    
    // Add the data-in-code load command size, if used.
    /*uint*/int NumDataRegions = Asm.getDataRegions().size();
    if ((NumDataRegions != 0)) {
      ++NumLoadCommands;
      LoadCommandsSize += $uint2ullong(MachO.linkedit_data_command.$sizeof_Linkedit_data_command());
    }
    
    // Add the loh load command size, if used.
    long/*uint64_t*/ LOHRawSize = Asm.getLOHContainer().getEmitSize(/*Deref*/this, Layout);
    long/*uint64_t*/ LOHSize = alignTo(LOHRawSize, $int2ulong(is64Bit() ? 8 : 4));
    if ((LOHSize != 0)) {
      ++NumLoadCommands;
      LoadCommandsSize += $uint2ullong(MachO.linkedit_data_command.$sizeof_Linkedit_data_command());
    }
    
    // Add the symbol table load command sizes, if used.
    /*uint*/int NumSymbols = LocalSymbolData.size() + ExternalSymbolData.size()
       + UndefinedSymbolData.size();
    if ((NumSymbols != 0)) {
      NumLoadCommands += 2;
      LoadCommandsSize += $uint2ullong((MachO.symtab_command.$sizeof_Symtab_command()
         + MachO.dysymtab_command.$sizeof_Dysymtab_command()));
    }
    
    // Add the linker option load commands sizes.
    for (final /*const*/std.vectorString /*&*/ Option : Asm.getLinkerOptions()) {
      ++NumLoadCommands;
      LoadCommandsSize += $uint2ullong(ComputeLinkerOptionsLoadCommandSize(Option, is64Bit()));
    }
    
    // Compute the total size of the section data, as well as its file size and vm
    // size.
    long/*uint64_t*/ SectionDataStart = $uint2ullong((is64Bit() ? MachO.mach_header_64.$sizeof_Mach_header_64() : MachO.mach_header.$sizeof_Mach_header())) + LoadCommandsSize;
    long/*uint64_t*/ SectionDataSize = $int2ulong(0);
    long/*uint64_t*/ SectionDataFileSize = $int2ulong(0);
    long/*uint64_t*/ VMSize = $int2ulong(0);
    for (final /*const*/ MCSection /*&*/ Sec : Asm) {
      long/*uint64_t*/ Address = getSectionAddress($AddrOf(Sec));
      long/*uint64_t*/ Size = Layout.getSectionAddressSize($AddrOf(Sec));
      long/*uint64_t*/ FileSize = Layout.getSectionFileSize($AddrOf(Sec));
      FileSize += getPaddingSize($AddrOf(Sec), Layout);
      
      VMSize = std.max(VMSize, Address + Size);
      if (Sec.isVirtualSection()) {
        continue;
      }
      
      SectionDataSize = std.max(SectionDataSize, Address + Size);
      SectionDataFileSize = std.max(SectionDataFileSize, Address + FileSize);
    }
    
    // The section data is padded to 4 bytes.
    //
    // FIXME: Is this machine dependent?
    /*uint*/int SectionDataPadding = $ulong2uint(OffsetToAlignment(SectionDataFileSize, $int2ulong(4)));
    SectionDataFileSize += $uint2ullong(SectionDataPadding);
    
    // Write the prolog, starting with the header and load command...
    writeHeader(MachO.HeaderFileType.MH_OBJECT, NumLoadCommands, $ulong2uint(LoadCommandsSize), 
        Asm.getSubsectionsViaSymbols());
    /*uint32_t*/int Prot = MachO.VM_PROT_READ | MachO.VM_PROT_WRITE | MachO.VM_PROT_EXECUTE;
    writeSegmentLoadCommand(new StringRef(/*KEEP_STR*/$EMPTY), NumSections, $int2ulong(0), VMSize, SectionDataStart, 
        SectionDataSize, Prot, Prot);
    
    // ... and then the section headers.
    long/*uint64_t*/ RelocTableEnd = SectionDataStart + SectionDataFileSize;
    for (final /*const*/ MCSection /*&*/ Section : Asm) {
      final /*const*/ MCSectionMachO /*&*/ Sec = cast_MCSectionMachO(Section);
      final std.vector<RelAndSymbol> /*&*/ Relocs = Relocations.$at_T1$RR($AddrOf(Sec));
      /*uint*/int NumRelocs = Relocs.size();
      long/*uint64_t*/ SectionStart = SectionDataStart + getSectionAddress($AddrOf(Sec));
      /*uint*/int Flags = Sec.getTypeAndAttributes();
      if (Sec.hasInstructions()) {
        Flags |= MachO.S_ATTR_SOME_INSTRUCTIONS;
      }
      writeSection(Layout, Sec, getSectionAddress($AddrOf(Sec)), SectionStart, Flags, 
          RelocTableEnd, NumRelocs);
      RelocTableEnd += $uint2ullong(NumRelocs * MachO.any_relocation_info.$sizeof_Any_relocation_info());
    }
    
    // Write out the deployment target information, if it's available.
    if (VersionInfo.Major != 0) {
      assert ($less_uint(VersionInfo.Update, 256)) : "unencodable update target version";
      assert ($less_uint(VersionInfo.Minor, 256)) : "unencodable minor target version";
      assert ($less_uint(VersionInfo.Major, 65536)) : "unencodable major target version";
      /*uint32_t*/int EncodedVersion = VersionInfo.Update | (VersionInfo.Minor << 8)
         | (VersionInfo.Major << 16);
      /*MachO::LoadCommandType*//*uint32_t*/int LCType = 0;
      switch (VersionInfo.Kind) {
       case MCVM_OSXVersionMin:
        LCType = MachO.LoadCommandType.LC_VERSION_MIN_MACOSX;
        break;
       case MCVM_IOSVersionMin:
        LCType = MachO.LoadCommandType.LC_VERSION_MIN_IPHONEOS;
        break;
       case MCVM_TvOSVersionMin:
        LCType = MachO.LoadCommandType.LC_VERSION_MIN_TVOS;
        break;
       case MCVM_WatchOSVersionMin:
        LCType = MachO.LoadCommandType.LC_VERSION_MIN_WATCHOS;
        break;
      }
      write32(LCType);
      write32(MachO.version_min_command.$sizeof_Version_min_command());
      write32(EncodedVersion);
      write32(0); // reserved.
    }
    
    // Write the data-in-code load command, if used.
    long/*uint64_t*/ DataInCodeTableEnd = RelocTableEnd + $uint2ullong(NumDataRegions * 8);
    if ((NumDataRegions != 0)) {
      long/*uint64_t*/ DataRegionsOffset = RelocTableEnd;
      long/*uint64_t*/ DataRegionsSize = $uint2ulong(NumDataRegions * 8);
      writeLinkeditLoadCommand(MachO.LoadCommandType.LC_DATA_IN_CODE, $ulong2uint(DataRegionsOffset), 
          $ulong2uint(DataRegionsSize));
    }
    
    // Write the loh load command, if used.
    long/*uint64_t*/ LOHTableEnd = DataInCodeTableEnd + LOHSize;
    if ((LOHSize != 0)) {
      writeLinkeditLoadCommand(MachO.LoadCommandType.LC_LINKER_OPTIMIZATION_HINT, 
          $ulong2uint(DataInCodeTableEnd), $ulong2uint(LOHSize));
    }
    
    // Write the symbol table load command, if used.
    if ((NumSymbols != 0)) {
      /*uint*/int FirstLocalSymbol = 0;
      /*uint*/int NumLocalSymbols = LocalSymbolData.size();
      /*uint*/int FirstExternalSymbol = FirstLocalSymbol + NumLocalSymbols;
      /*uint*/int NumExternalSymbols = ExternalSymbolData.size();
      /*uint*/int FirstUndefinedSymbol = FirstExternalSymbol + NumExternalSymbols;
      /*uint*/int NumUndefinedSymbols = UndefinedSymbolData.size();
      /*uint*/int NumIndirectSymbols = Asm.indirect_symbol_size();
      /*uint*/int NumSymTabSymbols = NumLocalSymbols + NumExternalSymbols + NumUndefinedSymbols;
      long/*uint64_t*/ IndirectSymbolSize = $uint2ulong(NumIndirectSymbols * 4);
      long/*uint64_t*/ IndirectSymbolOffset = $int2ulong(0);
      
      // If used, the indirect symbols are written after the section data.
      if ((NumIndirectSymbols != 0)) {
        IndirectSymbolOffset = LOHTableEnd;
      }
      
      // The symbol table is written after the indirect symbol data.
      long/*uint64_t*/ SymbolTableOffset = LOHTableEnd + IndirectSymbolSize;
      
      // The string table is written after symbol table.
      long/*uint64_t*/ StringTableOffset = SymbolTableOffset + $uint2ullong(NumSymTabSymbols * (is64Bit() ? MachO.nlist_64.$sizeof_Nlist_64() : MachO.nlist.$sizeof_Nlist()));
      writeSymtabLoadCommand($ulong2uint(SymbolTableOffset), NumSymTabSymbols, 
          $ulong2uint(StringTableOffset), StringTable.data().size());
      
      writeDysymtabLoadCommand(FirstLocalSymbol, NumLocalSymbols, 
          FirstExternalSymbol, NumExternalSymbols, 
          FirstUndefinedSymbol, NumUndefinedSymbols, 
          $ulong2uint(IndirectSymbolOffset), NumIndirectSymbols);
    }
    
    // Write the linker options load commands.
    for (final /*const*/std.vectorString /*&*/ Option : Asm.getLinkerOptions())  {
      writeLinkerOptionsLoadCommand(Option);
    }
    
    // Write the actual section data.
    for (final /*const*/ MCSection /*&*/ Sec : Asm) {
      Asm.writeSectionData($AddrOf(Sec), Layout);
      
      long/*uint64_t*/ Pad = getPaddingSize($AddrOf(Sec), Layout);
      WriteZeros($ulong2uint(Pad));
    }
    
    // Write the extra padding.
    WriteZeros(SectionDataPadding);
    
    // Write the relocation entries.
    for (final /*const*/ MCSection /*&*/ Sec : Asm) {
      // Write the section relocation entries, in reverse order to match 'as'
      // (approximately, the exact algorithm is more complicated than this).
      final std.vector<RelAndSymbol> /*&*/ Relocs = Relocations.$at_T1$RR($AddrOf(Sec));
      for (final /*const*/ RelAndSymbol /*&*/ Rel : make_range(Relocs.rbegin(), Relocs.rend())) {
        write32(Rel.MRE.r_word0);
        write32(Rel.MRE.r_word1);
      }
    }
    
    // Write out the data-in-code region payload, if there is one.
    for (std.vector.iterator</*const*/ DataRegionData /*P*/ > it = new std.vector.iterator</*const*/ DataRegionData /*P*/ >(Asm.data_region_begin()), ie = new std.vector.iterator</*const*/ DataRegionData /*P*/ >(Asm.data_region_end());
         $noteq___normal_iterator$C(it, ie); it.$preInc()) {
      /*const*/ DataRegionData /*P*/ Data = $AddrOf((it.$star()));
      long/*uint64_t*/ Start = getSymbolAddress($Deref(Data.Start), Layout);
      long/*uint64_t*/ End = getSymbolAddress($Deref(Data.End), Layout);
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"mc")) {
          dbgs().$out(/*KEEP_STR*/"data in code region-- kind: ").$out_int(Data.Kind.getValue()).$out(/*KEEP_STR*/"  start: ").$out_ullong(Start).$out(/*KEEP_STR*/$LPAREN).$out(Data.Start.getName()).$out(/*KEEP_STR*/$RPAREN).$out(/*KEEP_STR*/"  end: ").$out_ullong(End).$out(/*KEEP_STR*/$LPAREN).$out(Data.End.getName()).$out(/*KEEP_STR*/$RPAREN).$out(/*KEEP_STR*/"  size: ").$out_ullong(End - Start).$out(/*KEEP_STR*/$LF);
        }
      } while (false);
      write32($ulong2uint(Start));
      write16($ullong2ushort(End - Start));
      write16((char)Data.Kind.getValue());
    }
    
    // Write out the loh commands, if there is one.
    if ((LOHSize != 0)) {
      /*uint*/int Start = $ulong2uint(getStream().tell());
      Asm.getLOHContainer().emit(/*Deref*/this, Layout);
      // Pad to a multiple of the pointer size.
      writeBytes(new StringRef(/*KEEP_STR*/$EMPTY), $ulong2uint(OffsetToAlignment(LOHRawSize, $int2ulong(is64Bit() ? 8 : 4))));
      assert (getStream().tell() - $uint2ullong(Start) == LOHSize);
    }
    
    // Write the symbol table data, if used.
    if ((NumSymbols != 0)) {
      // Write the indirect symbol entries.
      for (std.vector.iterator</*const*/ IndirectSymbolData /*P*/ > it = new std.vector.iterator</*const*/ IndirectSymbolData /*P*/ >(Asm.indirect_symbol_begin()), 
          ie = new std.vector.iterator</*const*/ IndirectSymbolData /*P*/ >(Asm.indirect_symbol_end()); $noteq___normal_iterator$C(it, ie); it.$preInc()) {
        // Indirect symbols in the non-lazy symbol pointer section have some
        // special handling.
        final /*const*/ MCSectionMachO /*&*/ Section = ((/*static_cast*//*const*/ MCSectionMachO /*&*/ )($Deref(it.$arrow().Section)));
        if (Section.getType() == MachO.SectionType.S_NON_LAZY_SYMBOL_POINTERS) {
          // If this symbol is defined and internal, mark it as such.
          if (it.$arrow().Symbol.isDefined() && !it.$arrow().Symbol.isExternal()) {
            /*uint32_t*/int Flags = MachO.INDIRECT_SYMBOL_LOCAL;
            if (it.$arrow().Symbol.isAbsolute()) {
              Flags |= MachO.INDIRECT_SYMBOL_ABS;
            }
            write32(Flags);
            continue;
          }
        }
        
        write32(it.$arrow().Symbol.getIndex());
      }
      
      // FIXME: Check that offsets match computed ones.
      
      // Write the symbol table entries.
      for (std.vector<MachSymbolData/*,default_cls_allocator*/> /*P*/ SymbolData : new std.vector /*P*/ /*const*/ [/*3*/] {$AddrOf(LocalSymbolData), $AddrOf(ExternalSymbolData), $AddrOf(UndefinedSymbolData)})  {
        for (final MachSymbolData /*&*/ Entry : $Deref(SymbolData))  {
          writeNlist(Entry, Layout);
        }
      }
      
      // Write the string table.
      getStream().$out(StringTable.data());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MachObjectWriter::~MachObjectWriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", line = 74,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", old_line = 75,
   FQN="llvm::MachObjectWriter::~MachObjectWriter", NM="_ZN4llvm16MachObjectWriterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZN4llvm16MachObjectWriterD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    UndefinedSymbolData.$destroy();
    ExternalSymbolData.$destroy();
    LocalSymbolData.$destroy();
    StringTable.$destroy();
    SectionAddress.$destroy();
    IndirectSymBase.$destroy();
    Relocations.$destroy();
    TargetObjectWriter.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "TargetObjectWriter=" + TargetObjectWriter // NOI18N
              + ", Relocations=" + Relocations // NOI18N
              + ", IndirectSymBase=" + IndirectSymBase // NOI18N
              + ", SectionAddress=" + SectionAddress // NOI18N
              + ", StringTable=" + "[StringTableBuilder]" // NOI18N
              + ", LocalSymbolData=" + LocalSymbolData // NOI18N
              + ", ExternalSymbolData=" + ExternalSymbolData // NOI18N
              + ", UndefinedSymbolData=" + UndefinedSymbolData // NOI18N
              + super.toString(); // NOI18N
  }
}
