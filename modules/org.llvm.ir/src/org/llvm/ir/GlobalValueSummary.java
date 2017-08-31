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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.adt.ADTFunctionPointers.*;
import org.llvm.llvmc.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.Metadata.*;
import org.llvm.ir.intrinsic.*;
import static org.llvm.ir.java.IRFunctionPointers.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.cl.*;
import org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.ir.java.IRMemberPointers.*;
import org.llvm.ir.java.*;
import org.llvm.pass.*;
import org.llvm.support.dwarf.Tag;
import org.llvm.support.sys.SmartRWMutex;
import org.llvm.ir.java.cst_pred_ty_Predicate;
import org.llvm.ir.legacy.PassManagerBase;
import org.llvm.ir.PassManagerGlobals.*;
import org.llvm.ir.java.MDNodeKeyImpl;
import static org.llvm.adt.HashingGlobals.*;


/// \brief Function and variable summary information to aid decisions and
/// implementation of importing.
//<editor-fold defaultstate="collapsed" desc="llvm::GlobalValueSummary">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 88,
 FQN="llvm::GlobalValueSummary", NM="_ZN4llvm18GlobalValueSummaryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm18GlobalValueSummaryE")
//</editor-fold>
public class GlobalValueSummary implements Destructors.ClassWithDestructor {
/*public:*/
  /// \brief Sububclass discriminator (for dyn_cast<> et al.)
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValueSummary::SummaryKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 91,
   FQN="llvm::GlobalValueSummary::SummaryKind", NM="_ZN4llvm18GlobalValueSummary11SummaryKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm18GlobalValueSummary11SummaryKindE")
  //</editor-fold>
  public enum SummaryKind implements Native.NativeUIntEnum {
    AliasKind(0),
    FunctionKind(AliasKind.getValue() + 1),
    GlobalVarKind(FunctionKind.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static SummaryKind valueOf(int val) {
      SummaryKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final SummaryKind[] VALUES;
      private static final SummaryKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (SummaryKind kind : SummaryKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new SummaryKind[min < 0 ? (1-min) : 0];
        VALUES = new SummaryKind[max >= 0 ? (1+max) : 0];
        for (SummaryKind kind : SummaryKind.values()) {
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
    private SummaryKind(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };

  /// Group flags (Linkage, hasSection, isOptSize, etc.) as a bitfield.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValueSummary::GVFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 94,
   FQN="llvm::GlobalValueSummary::GVFlags", NM="_ZN4llvm18GlobalValueSummary7GVFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm18GlobalValueSummary7GVFlagsE")
  //</editor-fold>
  public static class/*struct*/ GVFlags {
    /// \brief The linkage type of the associated global value.
    ///
    /// One use is to flag values that have local linkage types and need to
    /// have module identifier appended before placing into the combined
    /// index, to disambiguate from other values with the same name.
    /// In the future this will be used to update and optimize linkage
    /// types based on global summary-based analysis.
    public /*JBYTE unsigned int*/ byte Linkage /*: 4*/;

    /// Indicate if the global value is located in a specific section.
    public /*JBIT unsigned int*/ boolean HasSection /*: 1*/;

    /// Convenience Constructors
    //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValueSummary::GVFlags::GVFlags">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 108,
     FQN="llvm::GlobalValueSummary::GVFlags::GVFlags", NM="_ZN4llvm18GlobalValueSummary7GVFlagsC1ENS_11GlobalValue12LinkageTypesEb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm18GlobalValueSummary7GVFlagsC1ENS_11GlobalValue12LinkageTypesEb")
    //</editor-fold>
    public /*explicit*/ GVFlags(GlobalValue.LinkageTypes Linkage, boolean HasSection) {
      // : Linkage(Linkage), HasSection(HasSection)
      //START JInit
      this.Linkage = $uint2uint_4bits(Linkage.getValue());
      this.HasSection = HasSection;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValueSummary::GVFlags::GVFlags">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 110,
     FQN="llvm::GlobalValueSummary::GVFlags::GVFlags", NM="_ZN4llvm18GlobalValueSummary7GVFlagsC1ERKNS_11GlobalValueE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm18GlobalValueSummary7GVFlagsC1ERKNS_11GlobalValueE")
    //</editor-fold>
    public GVFlags(final /*const*/ GlobalValue /*&*/ GV) {
      // : Linkage(GV.getLinkage()), HasSection(GV.hasSection())
      //START JInit
      this.Linkage = $uint2uint_4bits(GV.getLinkage().getValue());
      this.HasSection = GV.hasSection();
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValueSummary::GVFlags::GVFlags">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 94,
     FQN="llvm::GlobalValueSummary::GVFlags::GVFlags", NM="_ZN4llvm18GlobalValueSummary7GVFlagsC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm18GlobalValueSummary7GVFlagsC1ERKS1_")
    //</editor-fold>
    public /*inline*/ GVFlags(final /*const*/ GVFlags /*&*/ $Prm0) {
      // : Linkage(.Linkage), HasSection(.HasSection)
      //START JInit
      this.Linkage = $uint2uint_4bits($4bits_uint2uint($Prm0.Linkage));
      this.HasSection = $Prm0.HasSection;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValueSummary::GVFlags::GVFlags">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 94,
     FQN="llvm::GlobalValueSummary::GVFlags::GVFlags", NM="_ZN4llvm18GlobalValueSummary7GVFlagsC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm18GlobalValueSummary7GVFlagsC1EOS1_")
    //</editor-fold>
    public /*inline*/ GVFlags(JD$Move _dparam, final GVFlags /*&&*/$Prm0) {
      // : Linkage(static_cast<GVFlags &&>().Linkage), HasSection(static_cast<GVFlags &&>().HasSection)
      //START JInit
      this.Linkage = $uint2uint_4bits($4bits_uint2uint($Prm0.Linkage));
      this.HasSection = $Prm0.HasSection;
      //END JInit
    }


    @Override public String toString() {
      return "" + "Linkage=" + $uchar2uint(Linkage) // NOI18N
                + ", HasSection=" + HasSection; // NOI18N
    }
  };
/*private:*/
  /// Kind of summary for use in dyn_cast<> et al.
  private SummaryKind Kind;

  /// This is the hash of the name of the symbol in the original file. It is
  /// identical to the GUID for global symbols, but differs for local since the
  /// GUID includes the module level id in the hash.
  private long/*uint64_t*/ OriginalName;

  /// \brief Path of module IR containing value's definition, used to locate
  /// module during importing.
  ///
  /// This is only used during parsing of the combined index, or when
  /// parsing the per-module index for creation of the combined summary index,
  /// not during writing of the per-module index which doesn't contain a
  /// module path string table.
  private StringRef ModulePath;

  private GVFlags Flags;

  /// List of values referenced by this global value's definition
  /// (either by the initializer of a global variable, or referenced
  /// from within a function). This does not include functions called, which
  /// are listed in the derived FunctionSummary object.
  private std.vector<ValueInfo> RefEdgeList;
/*protected:*/
  /// GlobalValueSummary constructor.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValueSummary::GlobalValueSummary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 142,
   FQN="llvm::GlobalValueSummary::GlobalValueSummary", NM="_ZN4llvm18GlobalValueSummaryC1ENS0_11SummaryKindENS0_7GVFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm18GlobalValueSummaryC1ENS0_11SummaryKindENS0_7GVFlagsE")
  //</editor-fold>
  protected GlobalValueSummary(SummaryKind K, GVFlags Flags) {
    // : Kind(K), ModulePath(), Flags(Flags), RefEdgeList()
    //START JInit
    this.Kind = K;
    this.ModulePath = new StringRef();
    this.Flags = new GVFlags(Flags);
    this.RefEdgeList = new std.vector<ValueInfo>(new ValueInfo());
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValueSummary::~GlobalValueSummary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 145,
   FQN="llvm::GlobalValueSummary::~GlobalValueSummary", NM="_ZN4llvm18GlobalValueSummaryD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm18GlobalValueSummaryD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy()/* = default*/ {
    //START JDestroy
    RefEdgeList.$destroy();
    //END JDestroy
  }


  /// Returns the hash of the original name, it is identical to the GUID for
  /// externally visible symbols, but not for local ones.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValueSummary::getOriginalName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 149,
   FQN="llvm::GlobalValueSummary::getOriginalName", NM="_ZN4llvm18GlobalValueSummary15getOriginalNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm18GlobalValueSummary15getOriginalNameEv")
  //</editor-fold>
  public long/*uint64_t*/ getOriginalName() {
    return OriginalName;
  }


  /// Initialize the original name hash in this summary.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValueSummary::setOriginalName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 152,
   FQN="llvm::GlobalValueSummary::setOriginalName", NM="_ZN4llvm18GlobalValueSummary15setOriginalNameEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm18GlobalValueSummary15setOriginalNameEy")
  //</editor-fold>
  public void setOriginalName(long/*uint64_t*/ Name) {
    OriginalName = Name;
  }


  /// Which kind of summary subclass this is.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValueSummary::getSummaryKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 155,
   FQN="llvm::GlobalValueSummary::getSummaryKind", NM="_ZNK4llvm18GlobalValueSummary14getSummaryKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZNK4llvm18GlobalValueSummary14getSummaryKindEv")
  //</editor-fold>
  public SummaryKind getSummaryKind() /*const*/ {
    return Kind;
  }


  /// Set the path to the module containing this function, for use in
  /// the combined index.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValueSummary::setModulePath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 159,
   FQN="llvm::GlobalValueSummary::setModulePath", NM="_ZN4llvm18GlobalValueSummary13setModulePathENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm18GlobalValueSummary13setModulePathENS_9StringRefE")
  //</editor-fold>
  public void setModulePath(StringRef ModPath) {
    ModulePath.$assign(ModPath);
  }


  /// Get the path to the module containing this function.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValueSummary::modulePath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 162,
   FQN="llvm::GlobalValueSummary::modulePath", NM="_ZNK4llvm18GlobalValueSummary10modulePathEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZNK4llvm18GlobalValueSummary10modulePathEv")
  //</editor-fold>
  public StringRef modulePath() /*const*/ {
    return new StringRef(ModulePath);
  }


  /// Get the flags for this GlobalValue (see \p struct GVFlags).
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValueSummary::flags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 165,
   FQN="llvm::GlobalValueSummary::flags", NM="_ZN4llvm18GlobalValueSummary5flagsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm18GlobalValueSummary5flagsEv")
  //</editor-fold>
  public GVFlags flags() {
    return new GVFlags(Flags);
  }


  /// Return linkage type recorded for this global value.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValueSummary::linkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 168,
   FQN="llvm::GlobalValueSummary::linkage", NM="_ZNK4llvm18GlobalValueSummary7linkageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZNK4llvm18GlobalValueSummary7linkageEv")
  //</editor-fold>
  public GlobalValue.LinkageTypes linkage() /*const*/ {
    return /*static_cast*/GlobalValue.LinkageTypes.valueOf($4bits_uint2uint(Flags.Linkage));
  }


  /// Sets the linkage to the value determined by global summary-based
  /// optimization. Will be applied in the ThinLTO backends.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValueSummary::setLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 174,
   FQN="llvm::GlobalValueSummary::setLinkage", NM="_ZN4llvm18GlobalValueSummary10setLinkageENS_11GlobalValue12LinkageTypesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm18GlobalValueSummary10setLinkageENS_11GlobalValue12LinkageTypesE")
  //</editor-fold>
  public void setLinkage(GlobalValue.LinkageTypes Linkage) {
    Flags.Linkage = $uint2uint_4bits(Linkage.getValue());
  }


  /// Return true if this summary is for a GlobalValue that needs promotion
  /// to be referenced from another module.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValueSummary::needsRenaming">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 180,
   FQN="llvm::GlobalValueSummary::needsRenaming", NM="_ZNK4llvm18GlobalValueSummary13needsRenamingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZNK4llvm18GlobalValueSummary13needsRenamingEv")
  //</editor-fold>
  public boolean needsRenaming() /*const*/ {
    return GlobalValue.isLocalLinkage(linkage());
  }


  /// Return true if this global value is located in a specific section.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValueSummary::hasSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 183,
   FQN="llvm::GlobalValueSummary::hasSection", NM="_ZNK4llvm18GlobalValueSummary10hasSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZNK4llvm18GlobalValueSummary10hasSectionEv")
  //</editor-fold>
  public boolean hasSection() /*const*/ {
    return Flags.HasSection;
  }


  /// Record a reference from this global value to the global value identified
  /// by \p RefGUID.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValueSummary::addRefEdge">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 187,
   FQN="llvm::GlobalValueSummary::addRefEdge", NM="_ZN4llvm18GlobalValueSummary10addRefEdgeEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm18GlobalValueSummary10addRefEdgeEy")
  //</editor-fold>
  public void addRefEdge(long/*uint64_t*/ RefGUID) {
    RefEdgeList.push_back_T$RR(new ValueInfo(RefGUID));
  }


  /// Record a reference from this global value to the global value identified
  /// by \p RefV.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValueSummary::addRefEdge">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 191,
   FQN="llvm::GlobalValueSummary::addRefEdge", NM="_ZN4llvm18GlobalValueSummary10addRefEdgeEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm18GlobalValueSummary10addRefEdgeEPKNS_5ValueE")
  //</editor-fold>
  public void addRefEdge(/*const*/ Value /*P*/ RefV) {
    RefEdgeList.push_back_T$RR(new ValueInfo(RefV));
  }


  /// Record a reference from this global value to each global value identified
  /// in \p RefEdges.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValueSummary::addRefEdges">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 195,
   FQN="llvm::GlobalValueSummary::addRefEdges", NM="_ZN4llvm18GlobalValueSummary11addRefEdgesERNS_8DenseSetIPKNS_5ValueENS_12DenseMapInfoIS4_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm18GlobalValueSummary11addRefEdgesERNS_8DenseSetIPKNS_5ValueENS_12DenseMapInfoIS4_EEEE")
  //</editor-fold>
  public void addRefEdges(final DenseSet</*const*/ Value /*P*/ > /*&*/ RefEdges) {
    for (final /*const*/ Value /*P*/ /*&*/ RI : RefEdges)  {
      addRefEdge(RI);
    }
  }


  /// Return the list of values referenced by this global value definition.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValueSummary::refs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 201,
   FQN="llvm::GlobalValueSummary::refs", NM="_ZN4llvm18GlobalValueSummary4refsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm18GlobalValueSummary4refsEv")
  //</editor-fold>
  public std.vector<ValueInfo> /*&*/ refs() {
    return RefEdgeList;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValueSummary::refs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 202,
   FQN="llvm::GlobalValueSummary::refs", NM="_ZNK4llvm18GlobalValueSummary4refsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZNK4llvm18GlobalValueSummary4refsEv")
  //</editor-fold>
  public /*const*/std.vector<ValueInfo> /*&*/ refs$Const() /*const*/ {
    return RefEdgeList;
  }


  @Override public String toString() {
    return "" + "Kind=" + Kind // NOI18N
              + ", OriginalName=" + OriginalName // NOI18N
              + ", ModulePath=" + ModulePath // NOI18N
              + ", Flags=" + Flags // NOI18N
              + ", RefEdgeList=" + RefEdgeList; // NOI18N
  }
}
