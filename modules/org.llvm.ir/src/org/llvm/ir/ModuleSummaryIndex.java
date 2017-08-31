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

import java.util.Iterator;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import org.clank.java.stdimpl.aliases.StdMapULongType;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.clank.support.JavaCleaner.JC$Push;
import static org.clank.support.JavaCleaner.JC$Pop;
import static org.clank.support.JavaCleaner.JC$Top;
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


/// Class to hold module path string table and global value map,
/// and encapsulate methods for operating on them.
//<editor-fold defaultstate="collapsed" desc="llvm::ModuleSummaryIndex">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 341,
 FQN="llvm::ModuleSummaryIndex", NM="_ZN4llvm18ModuleSummaryIndexE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp -nm=_ZN4llvm18ModuleSummaryIndexE")
//</editor-fold>
public class ModuleSummaryIndex implements Iterable<std.pairULongType<std.vector<unique_ptr<GlobalValueSummary>>>>, Destructors.ClassWithDestructor {
/*private:*/
  /// Map from value name to list of summary instances for values of that
  /// name (may be duplicates in the COMDAT case, e.g.).
  private std.mapULongType<std.vector<std.unique_ptr<GlobalValueSummary>>> GlobalValueMap;

  /// Holds strings for combined index, mapping to the corresponding module ID.
  private StringMap<std.pairULongType<std.arrayUInt>> ModulePathStringTable;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleSummaryIndex::ModuleSummaryIndex">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 351,
   FQN="llvm::ModuleSummaryIndex::ModuleSummaryIndex", NM="_ZN4llvm18ModuleSummaryIndexC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp -nm=_ZN4llvm18ModuleSummaryIndexC1Ev")
  //</editor-fold>
  public ModuleSummaryIndex() {
    // : GlobalValueMap(), ModulePathStringTable()/* = default*/
    //START JInit
    this.GlobalValueMap = new std.mapULongType<std.vector<std.unique_ptr<GlobalValueSummary>>>(new std.vector<std.unique_ptr<GlobalValueSummary>>(() -> new unique_ptr()));
    this.ModulePathStringTable = new StringMap<std.pairULongType<std.arrayUInt>>(new std.pairULongType<std.arrayUInt>());
    //END JInit
  }


  // Disable the copy constructor and assignment operators, so
  // no unexpected copying/moving occurs.
  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleSummaryIndex::ModuleSummaryIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 355,
   FQN="llvm::ModuleSummaryIndex::ModuleSummaryIndex", NM="_ZN4llvm18ModuleSummaryIndexC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp -nm=_ZN4llvm18ModuleSummaryIndexC1ERKS0_")
  //</editor-fold>
  public ModuleSummaryIndex(final /*const*/ ModuleSummaryIndex /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleSummaryIndex::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 356,
   FQN="llvm::ModuleSummaryIndex::operator=", NM="_ZN4llvm18ModuleSummaryIndexaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp -nm=_ZN4llvm18ModuleSummaryIndexaSERKS0_")
  //</editor-fold>
  public void $assign(final /*const*/ ModuleSummaryIndex /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}


  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleSummaryIndex::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 358,
   FQN="llvm::ModuleSummaryIndex::begin", NM="_ZN4llvm18ModuleSummaryIndex5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp -nm=_ZN4llvm18ModuleSummaryIndex5beginEv")
  //</editor-fold>
  public std.mapULongType.iterator<std.vector<unique_ptr<GlobalValueSummary>/*,default_cls_allocator*/>> begin() {
    return GlobalValueMap.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleSummaryIndex::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 359,
   FQN="llvm::ModuleSummaryIndex::begin", NM="_ZNK4llvm18ModuleSummaryIndex5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp -nm=_ZNK4llvm18ModuleSummaryIndex5beginEv")
  //</editor-fold>
  public std.mapULongType.iterator<std.vector<unique_ptr<GlobalValueSummary>/*,default_cls_allocator*/>> begin$Const() /*const*/ {
    return GlobalValueMap.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleSummaryIndex::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 360,
   FQN="llvm::ModuleSummaryIndex::end", NM="_ZN4llvm18ModuleSummaryIndex3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp -nm=_ZN4llvm18ModuleSummaryIndex3endEv")
  //</editor-fold>
  public std.mapULongType.iterator<std.vector<unique_ptr<GlobalValueSummary>/*,default_cls_allocator*/>> end() {
    return GlobalValueMap.end();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleSummaryIndex::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 361,
   FQN="llvm::ModuleSummaryIndex::end", NM="_ZNK4llvm18ModuleSummaryIndex3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp -nm=_ZNK4llvm18ModuleSummaryIndex3endEv")
  //</editor-fold>
  public std.mapULongType.iterator<std.vector<unique_ptr<GlobalValueSummary>/*,default_cls_allocator*/>> end$Const() /*const*/ {
    return GlobalValueMap.end$Const();
  }


  /// Get the list of global value summary objects for a given value name.
  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleSummaryIndex::getGlobalValueSummaryList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 364,
   FQN="llvm::ModuleSummaryIndex::getGlobalValueSummaryList", NM="_ZN4llvm18ModuleSummaryIndex25getGlobalValueSummaryListENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp -nm=_ZN4llvm18ModuleSummaryIndex25getGlobalValueSummaryListENS_9StringRefE")
  //</editor-fold>
  public /*const*/std.vector<std.unique_ptr<GlobalValueSummary>> /*&*/ getGlobalValueSummaryList(StringRef ValueName) {
    return GlobalValueMap.$at_T$RR(GlobalValue.getGUID(new StringRef(ValueName)));
  }


  /// Get the list of global value summary objects for a given value name.
  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleSummaryIndex::findGlobalValueSummaryList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 369,
   FQN="llvm::ModuleSummaryIndex::findGlobalValueSummaryList", NM="_ZNK4llvm18ModuleSummaryIndex26findGlobalValueSummaryListENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp -nm=_ZNK4llvm18ModuleSummaryIndex26findGlobalValueSummaryListENS_9StringRefE")
  //</editor-fold>
  public std.mapULongType.iterator<std.vector<unique_ptr<GlobalValueSummary>/*,default_cls_allocator*/>> findGlobalValueSummaryList(StringRef ValueName) /*const*/ {
    return GlobalValueMap.find$Const(GlobalValue.getGUID(new StringRef(ValueName)));
  }


  /// Get the list of global value summary objects for a given value GUID.
  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleSummaryIndex::findGlobalValueSummaryList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 375,
   FQN="llvm::ModuleSummaryIndex::findGlobalValueSummaryList", NM="_ZNK4llvm18ModuleSummaryIndex26findGlobalValueSummaryListEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp -nm=_ZNK4llvm18ModuleSummaryIndex26findGlobalValueSummaryListEy")
  //</editor-fold>
  public std.mapULongType.iterator<std.vector<unique_ptr<GlobalValueSummary>/*,default_cls_allocator*/>> findGlobalValueSummaryList(long/*uint64_t*/ ValueGUID) /*const*/ {
    return GlobalValueMap.find$Const(ValueGUID);
  }


  /// Add a global value summary for a value of the given name.
  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleSummaryIndex::addGlobalValueSummary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 381,
   FQN="llvm::ModuleSummaryIndex::addGlobalValueSummary", NM="_ZN4llvm18ModuleSummaryIndex21addGlobalValueSummaryENS_9StringRefESt10unique_ptrINS_18GlobalValueSummaryESt14default_deleteIS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp -nm=_ZN4llvm18ModuleSummaryIndex21addGlobalValueSummaryENS_9StringRefESt10unique_ptrINS_18GlobalValueSummaryESt14default_deleteIS3_EE")
  //</editor-fold>
  public void addGlobalValueSummary(StringRef ValueName,
                       std.unique_ptr<GlobalValueSummary> Summary) {
    GlobalValueMap.$at_T$RR(GlobalValue.getGUID(new StringRef(ValueName))).push_back_T$RR(std.move(Summary));
  }


  /// Add a global value summary for a value of the given GUID.
  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleSummaryIndex::addGlobalValueSummary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 388,
   FQN="llvm::ModuleSummaryIndex::addGlobalValueSummary", NM="_ZN4llvm18ModuleSummaryIndex21addGlobalValueSummaryEySt10unique_ptrINS_18GlobalValueSummaryESt14default_deleteIS2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp -nm=_ZN4llvm18ModuleSummaryIndex21addGlobalValueSummaryEySt10unique_ptrINS_18GlobalValueSummaryESt14default_deleteIS2_EE")
  //</editor-fold>
  public void addGlobalValueSummary(long/*uint64_t*/ ValueGUID,
                       std.unique_ptr<GlobalValueSummary> Summary) {
    GlobalValueMap.$at_T$C$R(ValueGUID).push_back_T$RR(std.move(Summary));
  }


  /// Find the summary for global \p GUID in module \p ModuleId, or nullptr if
  /// not found.
  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleSummaryIndex::findSummaryInModule">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 395,
   FQN="llvm::ModuleSummaryIndex::findSummaryInModule", NM="_ZNK4llvm18ModuleSummaryIndex19findSummaryInModuleEyNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp -nm=_ZNK4llvm18ModuleSummaryIndex19findSummaryInModuleEyNS_9StringRefE")
  //</editor-fold>
  public GlobalValueSummary /*P*/ findSummaryInModule(long/*uint64_t*/ ValueGUID, 
                     StringRef ModuleId) /*const*/ {
    std.mapULongType.iterator<vector<std_ptr.unique_ptr<GlobalValueSummary>>> CalleeInfoList = findGlobalValueSummaryList(ValueGUID);
    if (CalleeInfoList.$eq(end$Const())) {
      return null; // This function does not have a summary
    }
    std.vector.iterator</*const*/unique_ptr<GlobalValueSummary> /*P*/> Summary = llvm.find_if(CalleeInfoList.$arrow().second, 
        /*[&, &ModuleId]*/ (final /*const*/ std.unique_ptr<GlobalValueSummary> /*&*/ Summary$1) -> {
              return $eq_StringRef(Summary$1.$arrow().modulePath(), /*NO_COPY*/ModuleId);
            });
    if ($eq___normal_iterator$C(Summary, CalleeInfoList.$arrow().second.end$Const())) {
      return null;
    }
    return Summary.$arrow().get();
  }


  /// Returns the first GlobalValueSummary for \p GV, asserting that there
  /// is only one if \p PerModuleIndex.
  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleSummaryIndex::getGlobalValueSummary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 413,
   FQN="llvm::ModuleSummaryIndex::getGlobalValueSummary", NM="_ZNK4llvm18ModuleSummaryIndex21getGlobalValueSummaryERKNS_11GlobalValueEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp -nm=_ZNK4llvm18ModuleSummaryIndex21getGlobalValueSummaryERKNS_11GlobalValueEb")
  //</editor-fold>
  public GlobalValueSummary /*P*/ getGlobalValueSummary(final /*const*/ GlobalValue /*&*/ GV) /*const*/ {
    return getGlobalValueSummary(GV,
                       true);
  }
  public GlobalValueSummary /*P*/ getGlobalValueSummary(final /*const*/ GlobalValue /*&*/ GV,
                       boolean PerModuleIndex/*= true*/) /*const*/ {
    assert (GV.hasName()) : "Can't get GlobalValueSummary for GV with no name";
    return getGlobalValueSummary(GlobalValue.getGUID(GV.getName()),
        PerModuleIndex);
  }


  /// Returns the first GlobalValueSummary for \p ValueGUID, asserting that
  /// there
  /// is only one if \p PerModuleIndex.

  /// Returns the first GlobalValueSummary for \p ValueGUID, asserting that
  /// there
  /// is only one if \p PerModuleIndex.
  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleSummaryIndex::getGlobalValueSummary">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/ModuleSummaryIndex.cpp", line = 98,
   FQN="llvm::ModuleSummaryIndex::getGlobalValueSummary", NM="_ZNK4llvm18ModuleSummaryIndex21getGlobalValueSummaryEyb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ModuleSummaryIndex.cpp -nm=_ZNK4llvm18ModuleSummaryIndex21getGlobalValueSummaryEyb")
  //</editor-fold>
  public GlobalValueSummary /*P*/ getGlobalValueSummary(long/*uint64_t*/ ValueGUID) /*const*/ {
    return getGlobalValueSummary(ValueGUID,
                       true);
  }
  public GlobalValueSummary /*P*/ getGlobalValueSummary(long/*uint64_t*/ ValueGUID,
                       boolean PerModuleIndex/*= true*/) /*const*/ {
    std.mapULongType.iterator<vector<std_ptr.unique_ptr<GlobalValueSummary>>> SummaryList = findGlobalValueSummaryList(ValueGUID);
    assert (SummaryList.$noteq(end$Const())) : "GlobalValue not found in index";
    assert ((!PerModuleIndex || SummaryList.$arrow().second.size() == 1)) : "Expected a single entry per global value in per-module index";
    final /*constconst*/unique_ptr<GlobalValueSummary> /*&*/ Summary = SummaryList.$arrow().second.$at$Const(0);
    return Summary.get();
  }



  /// Table of modules, containing module hash and id.
  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleSummaryIndex::modulePaths">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 427,
   FQN="llvm::ModuleSummaryIndex::modulePaths", NM="_ZNK4llvm18ModuleSummaryIndex11modulePathsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp -nm=_ZNK4llvm18ModuleSummaryIndex11modulePathsEv")
  //</editor-fold>
  public /*const*/StringMap<std.pairULongType<std.arrayUInt>> /*&*/ modulePaths$Const() /*const*/ {
    return ModulePathStringTable;
  }


  /// Table of modules, containing hash and id.
  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleSummaryIndex::modulePaths">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 432,
   FQN="llvm::ModuleSummaryIndex::modulePaths", NM="_ZN4llvm18ModuleSummaryIndex11modulePathsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp -nm=_ZN4llvm18ModuleSummaryIndex11modulePathsEv")
  //</editor-fold>
  public StringMap<std.pairULongType<std.arrayUInt>> /*&*/ modulePaths() {
    return ModulePathStringTable;
  }


  /// Get the module ID recorded for the given module path.
  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleSummaryIndex::getModuleId">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 437,
   FQN="llvm::ModuleSummaryIndex::getModuleId", NM="_ZNK4llvm18ModuleSummaryIndex11getModuleIdENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp -nm=_ZNK4llvm18ModuleSummaryIndex11getModuleIdENS_9StringRefE")
  //</editor-fold>
  public long/*uint64_t*/ getModuleId(/*const*/ StringRef ModPath) /*const*/ {
    return ModulePathStringTable.lookup(new StringRef(ModPath)).first;
  }


  /// Get the module SHA1 hash recorded for the given module path.
  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleSummaryIndex::getModuleHash">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 442,
   FQN="llvm::ModuleSummaryIndex::getModuleHash", NM="_ZNK4llvm18ModuleSummaryIndex13getModuleHashENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp -nm=_ZNK4llvm18ModuleSummaryIndex13getModuleHashENS_9StringRefE")
  //</editor-fold>
  public /*const*/std.arrayUInt /*&*/ getModuleHash(/*const*/ StringRef ModPath) /*const*/ {
    StringMapIterator<pairULongType<arrayUInt>> It = ModulePathStringTable.find$Const(/*NO_COPY*/ModPath);
    assert (It.$noteq(ModulePathStringTable.end$Const())) : "Module not registered";
    return It.$arrow().second.second;
  }


  /// Add the given per-module index into this module index/summary,
  /// assigning it the given module ID. Each module merged in should have
  /// a unique ID, necessary for consistent renaming of promoted
  /// static (local) variables.

  /// Add the given per-module index into this module index/summary,
  /// assigning it the given module ID. Each module merged in should have
  /// a unique ID, necessary for consistent renaming of promoted
  /// static (local) variables.

  // Create the combined module index/summary from multiple
  // per-module instances.
  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleSummaryIndex::mergeFrom">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ModuleSummaryIndex.cpp", line = 21,
   FQN="llvm::ModuleSummaryIndex::mergeFrom", NM="_ZN4llvm18ModuleSummaryIndex9mergeFromESt10unique_ptrIS0_St14default_deleteIS0_EEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ModuleSummaryIndex.cpp -nm=_ZN4llvm18ModuleSummaryIndex9mergeFromESt10unique_ptrIS0_St14default_deleteIS0_EEy")
  //</editor-fold>
  public void mergeFrom(std.unique_ptr<ModuleSummaryIndex> Other,
           long/*uint64_t*/ NextModuleId) {

    StringRef ModPath/*J*/= new StringRef();
    for (final std.pairULongType<std.vector<unique_ptr<GlobalValueSummary>/*,default_cls_allocator*/>> /*&*/ OtherGlobalValSummaryLists : Other.$star()) {
      std.unique_ptr<GlobalValueSummary> Summary = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        long/*uint64_t*/ ValueGUID = OtherGlobalValSummaryLists.first;
        final std.vector<std.unique_ptr<GlobalValueSummary>> /*&*/ List = OtherGlobalValSummaryLists.second;

        // Assert that the value summary list only has one entry, since we shouldn't
        // have duplicate names within a single per-module index.
        assert (List.size() == 1);
        Summary = new std.unique_ptr<GlobalValueSummary>(JD$Move.INSTANCE, std.move(List.front()));

        // Add the module path string ref for this module if we haven't already
        // saved a reference to it.
        if (ModPath.empty()) {
          StringRef Path = Summary.$arrow().modulePath();
          ModPath.$assignMove(addModulePath(new StringRef(Path), NextModuleId, new std.arrayUInt(Other.$arrow().getModuleHash(new StringRef(Path)))).$arrow().
                  first());
        } else {
          assert ($eq_StringRef(/*NO_COPY*/ModPath, Summary.$arrow().modulePath())) : "Each module in the combined map should have a unique ID";
        }

        // Note the module path string ref was copied above and is still owned by
        // the original per-module index. Reset it to the new module path
        // string reference owned by the combined index.
        Summary.$arrow().setModulePath(new StringRef(ModPath));

        // Add new value summary to existing list. There may be duplicates when
        // combining GlobalValueMap entries, due to COMDAT values. Any local
        // values were given unique global IDs.
        addGlobalValueSummary(ValueGUID, $c$.track(new std.unique_ptr<GlobalValueSummary>(JD$Move.INSTANCE, std.move(Summary)))); $c$.clean();
      } finally {
        if (Summary != null) { Summary.$destroy(); }
        $c$.$destroy();
      }
    }
  }



  /// Convenience method for creating a promoted global name
  /// for the given value name of a local, and its original module's ID.
  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleSummaryIndex::getGlobalNameForLocal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 457,
   FQN="llvm::ModuleSummaryIndex::getGlobalNameForLocal", NM="_ZN4llvm18ModuleSummaryIndex21getGlobalNameForLocalENS_9StringRefESt5arrayIjLj5EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp -nm=_ZN4llvm18ModuleSummaryIndex21getGlobalNameForLocalENS_9StringRefESt5arrayIjLj5EE")
  //</editor-fold>
  public static std.string getGlobalNameForLocal(StringRef Name, std.arrayUInt ModHash) {
    SmallString/*<256>*/ NewName/*J*/= new SmallString/*<256>*/(256, new StringRef(Name));
    NewName.$addassign(/*STRINGREF_STR*/".llvm.");
    NewName.$addassign(new StringRef(utohexstr($uint2ulong(ModHash.$at(0))))); // Take the first 32 bits
    return NewName.str().$string();
  }


  /// Helper to obtain the unpromoted name for a global value (or the original
  /// name if not promoted).
  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleSummaryIndex::getOriginalNameBeforePromote">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 466,
   FQN="llvm::ModuleSummaryIndex::getOriginalNameBeforePromote", NM="_ZN4llvm18ModuleSummaryIndex28getOriginalNameBeforePromoteENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp -nm=_ZN4llvm18ModuleSummaryIndex28getOriginalNameBeforePromoteENS_9StringRefE")
  //</editor-fold>
  public static StringRef getOriginalNameBeforePromote(StringRef Name) {
    std.pairTypeType<StringRef, StringRef> Pair = Name.split(/*STRINGREF_STR*/".llvm.");
    return new StringRef(Pair.first);
  }


  /// Add a new module path with the given \p Hash, mapped to the given \p
  /// ModID, and return an iterator to the entry in the index.
  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleSummaryIndex::addModulePath">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 473,
   FQN="llvm::ModuleSummaryIndex::addModulePath", NM="_ZN4llvm18ModuleSummaryIndex13addModulePathENS_9StringRefEySt5arrayIjLj5EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp -nm=_ZN4llvm18ModuleSummaryIndex13addModulePathENS_9StringRefEySt5arrayIjLj5EE")
  //</editor-fold>
  public StringMapIterator<std.pairULongType<std.arrayUInt> > addModulePath(StringRef ModPath, long/*uint64_t*/ ModId) {
    return addModulePath(ModPath, ModId,
               ((std.arrayUInt)(new std.arrayUInt(5, new /*uint*/int [/*5*/] {0}))));
  }
  public StringMapIterator<std.pairULongType<std.arrayUInt> > addModulePath(StringRef ModPath, long/*uint64_t*/ ModId,
               std.arrayUInt Hash/*= std.ModuleHash({{0}})*/) {
    return new StringMapIterator<std.pairULongType<std.arrayUInt> >(JD$Move.INSTANCE, ModulePathStringTable.insert(std.make_pair($Clone(ModPath), $Move(std.make_pair_ulong_T(ModId, $Clone(Hash)))
                )).first);
  }


  /// Check if the given Module has any functions available for exporting
  /// in the index. We consider any module present in the ModulePathStringTable
  /// to have exported functions.
  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleSummaryIndex::hasExportedFunctions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 484,
   FQN="llvm::ModuleSummaryIndex::hasExportedFunctions", NM="_ZNK4llvm18ModuleSummaryIndex20hasExportedFunctionsERKNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp -nm=_ZNK4llvm18ModuleSummaryIndex20hasExportedFunctionsERKNS_6ModuleE")
  //</editor-fold>
  public boolean hasExportedFunctions(final /*const*/ Module /*&*/ M) /*const*/ {
    return (ModulePathStringTable.count(new StringRef(M.getModuleIdentifier())) != 0);
  }


  /// Remove entries in the GlobalValueMap that have empty summaries due to the
  /// eager nature of map entry creation during VST parsing. These would
  /// also be suppressed during combined index generation in mergeFrom(),
  /// but if there was only one module or this was the first module we might
  /// not invoke mergeFrom.

  /// Remove entries in the GlobalValueMap that have empty summaries due to the
  /// eager nature of map entry creation during VST parsing. These would
  /// also be suppressed during combined index generation in mergeFrom(),
  /// but if there was only one module or this was the first module we might
  /// not invoke mergeFrom.
  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleSummaryIndex::removeEmptySummaryEntries">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/ModuleSummaryIndex.cpp", line = 56,
   FQN="llvm::ModuleSummaryIndex::removeEmptySummaryEntries", NM="_ZN4llvm18ModuleSummaryIndex25removeEmptySummaryEntriesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ModuleSummaryIndex.cpp -nm=_ZN4llvm18ModuleSummaryIndex25removeEmptySummaryEntriesEv")
  //</editor-fold>
  public void removeEmptySummaryEntries() {
    for (std.mapULongType.iterator<vector<std_ptr.unique_ptr<GlobalValueSummary>/*,default_cls_allocator*/>> MI = begin(), MIE = end(); MI.$noteq(MIE);) {
      // Only expect this to be called on a per-module index, which has a single
      // entry per value entry list.
      assert (MI.$arrow().second.size() == 1);
      if (!MI.$arrow().second.$at(0).$bool()) {
        GlobalValueMap.erase($Clone(MI));
        MI.$preInc();
      } else {
        MI.$preInc();
      }
    }
  }



  /// Collect for the given module the list of function it defines
  /// (GUID -> Summary).

  /// Collect for the given module the list of function it defines
  /// (GUID -> Summary).

  // Collect for the given module the list of function it defines
  // (GUID -> Summary).
  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleSummaryIndex::collectDefinedFunctionsForModule">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/ModuleSummaryIndex.cpp", line = 70,
   FQN="llvm::ModuleSummaryIndex::collectDefinedFunctionsForModule", NM="_ZNK4llvm18ModuleSummaryIndex32collectDefinedFunctionsForModuleENS_9StringRefERSt3mapIyPNS_18GlobalValueSummaryESt4lessIyESaISt4pairIKyS4_EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ModuleSummaryIndex.cpp -nm=_ZNK4llvm18ModuleSummaryIndex32collectDefinedFunctionsForModuleENS_9StringRefERSt3mapIyPNS_18GlobalValueSummaryESt4lessIyESaISt4pairIKyS4_EEE")
  //</editor-fold>
  public void collectDefinedFunctionsForModule(StringRef ModulePath, final std.mapULongPtr<GlobalValueSummary /*P*/ /*P*/> /*&*/ GVSummaryMap) /*const*/ {
    for (final /*constconst*/std.pairULongType<std.vector<unique_ptr<GlobalValueSummary>/*,default_cls_allocator*/>> /*&*/ GlobalList : /*Deref*/this) {
      /*ullong*/long GUID = GlobalList.first;
      for (final /*constconst*/unique_ptr<GlobalValueSummary> /*&*/ GlobSummary : GlobalList.second) {
        FunctionSummary /*P*/ Summary = dyn_cast_or_null_FunctionSummary(GlobSummary.get());
        if (!(Summary != null)) {
          // Ignore global variable, focus on functions
          continue;
        }
        // Ignore summaries from other modules.
        if ($noteq_StringRef(Summary.modulePath(), /*NO_COPY*/ModulePath)) {
          continue;
        }
        GVSummaryMap.$set(GUID, Summary);
      }
    }
  }



  /// Collect for each module the list of Summaries it defines (GUID ->
  /// Summary).

  /// Collect for each module the list of Summaries it defines (GUID ->
  /// Summary).

  // Collect for each module the list of function it defines (GUID -> Summary).
  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleSummaryIndex::collectDefinedGVSummariesPerModule">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/ModuleSummaryIndex.cpp", line = 88,
   FQN="llvm::ModuleSummaryIndex::collectDefinedGVSummariesPerModule", NM="_ZNK4llvm18ModuleSummaryIndex34collectDefinedGVSummariesPerModuleERNS_9StringMapISt3mapIyPNS_18GlobalValueSummaryESt4lessIyESaISt4pairIKyS4_EEENS_15MallocAllocatorEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ModuleSummaryIndex.cpp -nm=_ZNK4llvm18ModuleSummaryIndex34collectDefinedGVSummariesPerModuleERNS_9StringMapISt3mapIyPNS_18GlobalValueSummaryESt4lessIyESaISt4pairIKyS4_EEENS_15MallocAllocatorEEE")
  //</editor-fold>
  public void collectDefinedGVSummariesPerModule(final StringMap<std.mapULongPtr<GlobalValueSummary /*P*/ /*P*/>> /*&*/ ModuleToDefinedGVSummaries) /*const*/ {
    for (final /*constconst*/std.pairULongType<std.vector<unique_ptr<GlobalValueSummary>/*,default_cls_allocator*/>> /*&*/ GlobalList : /*Deref*/this) {
      /*ullong*/long GUID = GlobalList.first;
      for (final /*constconst*/unique_ptr<GlobalValueSummary> /*&*/ Summary : GlobalList.second) {
        ModuleToDefinedGVSummaries.$at(Summary.$arrow().modulePath()).$set(GUID, Summary.get());
      }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleSummaryIndex::~ModuleSummaryIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 341,
   FQN="llvm::ModuleSummaryIndex::~ModuleSummaryIndex", NM="_ZN4llvm18ModuleSummaryIndexD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp -nm=_ZN4llvm18ModuleSummaryIndexD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    ModulePathStringTable.$destroy();
    GlobalValueMap.$destroy();
    //END JDestroy
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public @Override Iterator<std.pairULongType<std.vector<unique_ptr<GlobalValueSummary>>>> iterator() {
    return new JavaIterator<std.pairULongType<std.vector<unique_ptr<GlobalValueSummary>>>>(begin(), end());
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + "GlobalValueMap=" + GlobalValueMap // NOI18N
              + ", ModulePathStringTable=" + ModulePathStringTable; // NOI18N
  }
}
