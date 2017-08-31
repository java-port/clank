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

package org.clang.codegen.CodeGen.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.llvm.profiledata.*;
import org.clang.codegen.impl.*;
import org.llvm.ir.intrinsic.ID;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.clang.codegen.impl.CodeGenPGOStatics.*;
import org.llvm.profiledata.IndexedInstrProf.ProfVersion;
import static org.llvm.profiledata.impl.InstrProfLlvmGlobals.*;
import org.llvm.support.Error;


/// Per-function PGO state.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenPGO">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.h", line = 31,
 FQN="clang::CodeGen::CodeGenPGO", NM="_ZN5clang7CodeGen10CodeGenPGOE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen10CodeGenPGOE")
//</editor-fold>
public class CodeGenPGO implements Destructors.ClassWithDestructor {
/*private:*/
  private final CodeGenModule /*&*/ CGM;
  private std.string FuncName;
  private GlobalVariable /*P*/ FuncNameVar;
  
  private std.arrayUInt NumValueSites;
  private /*uint*/int NumRegionCounters;
  private long/*uint64_t*/ FunctionHash;
  private std.unique_ptr<DenseMapTypeUInt</*const*/ Stmt /*P*/ > > RegionCounterMap;
  private std.unique_ptr<DenseMapTypeULong</*const*/ Stmt /*P*/ > > StmtCountMap;
  private std.unique_ptr<InstrProfRecord> ProfRecord;
  private std.vectorULong RegionCounts;
  private long/*uint64_t*/ CurrentRegionCount;
  /// \brief A flag that is set to true when this function doesn't need
  /// to have coverage mapping data.
  private boolean SkipCoverageMapping;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenPGO::CodeGenPGO">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.h", line = 50,
   FQN="clang::CodeGen::CodeGenPGO::CodeGenPGO", NM="_ZN5clang7CodeGen10CodeGenPGOC1ERNS0_13CodeGenModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen10CodeGenPGOC1ERNS0_13CodeGenModuleE")
  //</editor-fold>
  public CodeGenPGO(final CodeGenModule /*&*/ CGM) {
    // : CGM(CGM), FuncName(), NumValueSites({{0}}), NumRegionCounters(0), FunctionHash(0), RegionCounterMap(), StmtCountMap(), ProfRecord(), RegionCounts(), CurrentRegionCount(0), SkipCoverageMapping(false) 
    //START JInit
    this./*&*/CGM=/*&*/CGM;
    this.FuncName = new std.string();
    this.NumValueSites = new std.arrayUInt(1, new /*uint*/int [/*-1*/] {0});
    this.NumRegionCounters = 0;
    this.FunctionHash = $int2ulong(0);
    this.RegionCounterMap = new std.unique_ptr<DenseMapTypeUInt</*const*/ Stmt /*P*/ > >();
    this.StmtCountMap = new std.unique_ptr<DenseMapTypeULong</*const*/ Stmt /*P*/ > >();
    this.ProfRecord = new std.unique_ptr<InstrProfRecord>();
    this.RegionCounts = new std.vectorULong();
    this.CurrentRegionCount = $int2ulong(0);
    this.SkipCoverageMapping = false;
    //END JInit
  }

  
  /// Whether or not we have PGO region data for the current function. This is
  /// false both when we have no data at all and when our data has been
  /// discarded.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenPGO::haveRegionCounts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.h", line = 57,
   FQN="clang::CodeGen::CodeGenPGO::haveRegionCounts", NM="_ZNK5clang7CodeGen10CodeGenPGO16haveRegionCountsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZNK5clang7CodeGen10CodeGenPGO16haveRegionCountsEv")
  //</editor-fold>
  public boolean haveRegionCounts() /*const*/ {
    return !RegionCounts.empty();
  }

  
  /// Return the counter value of the current region.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenPGO::getCurrentRegionCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.h", line = 60,
   FQN="clang::CodeGen::CodeGenPGO::getCurrentRegionCount", NM="_ZNK5clang7CodeGen10CodeGenPGO21getCurrentRegionCountEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZNK5clang7CodeGen10CodeGenPGO21getCurrentRegionCountEv")
  //</editor-fold>
  public long/*uint64_t*/ getCurrentRegionCount() /*const*/ {
    return CurrentRegionCount;
  }

  
  /// Set the counter value for the current region. This is used to keep track
  /// of changes to the most recent counter from control flow and non-local
  /// exits.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenPGO::setCurrentRegionCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.h", line = 65,
   FQN="clang::CodeGen::CodeGenPGO::setCurrentRegionCount", NM="_ZN5clang7CodeGen10CodeGenPGO21setCurrentRegionCountEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen10CodeGenPGO21setCurrentRegionCountEy")
  //</editor-fold>
  public void setCurrentRegionCount(long/*uint64_t*/ Count) {
    CurrentRegionCount = Count;
  }

  
  /// Check if an execution count is known for a given statement. If so, return
  /// true and put the value in Count; else return false.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenPGO::getStmtCount">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.h", line = 69,
   FQN="clang::CodeGen::CodeGenPGO::getStmtCount", NM="_ZN5clang7CodeGen10CodeGenPGO12getStmtCountEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen10CodeGenPGO12getStmtCountEPKNS_4StmtE")
  //</editor-fold>
  public OptionalULong getStmtCount(/*const*/ Stmt /*P*/ S) {
    if (!StmtCountMap.$bool()) {
      return new OptionalULong(None);
    }
    DenseMapIteratorTypeULong</*const*/ Stmt /*P*/ /*P*/> I = StmtCountMap.$arrow().find(S);
    if (I.$eq(/*NO_ITER_COPY*/StmtCountMap.$arrow().end())) {
      return new OptionalULong(None);
    }
    return new OptionalULong(JD$T$C$R.INSTANCE, I.$arrow().second);
  }

  
  /// If the execution count for the current statement is known, record that
  /// as the current count.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenPGO::setCurrentStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.h", line = 80,
   FQN="clang::CodeGen::CodeGenPGO::setCurrentStmt", NM="_ZN5clang7CodeGen10CodeGenPGO14setCurrentStmtEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen10CodeGenPGO14setCurrentStmtEPKNS_4StmtE")
  //</editor-fold>
  public void setCurrentStmt(/*const*/ Stmt /*P*/ S) {
    {
      OptionalULong Count = getStmtCount(S);
      if (Count.$bool()) {
        setCurrentRegionCount(Count.$star());
      }
    }
  }

  
  /// Assign counters to regions and configure them for PGO of a given
  /// function. Does nothing if instrumentation is not enabled and either
  /// generates global variables or associates PGO data with each of the
  /// counters depending on whether we are generating or using instrumentation.
  
  /// Assign counters to regions and configure them for PGO of a given
  /// function. Does nothing if instrumentation is not enabled and either
  /// generates global variables or associates PGO data with each of the
  /// counters depending on whether we are generating or using instrumentation.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenPGO::assignRegionCounters">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 614,
   FQN="clang::CodeGen::CodeGenPGO::assignRegionCounters", NM="_ZN5clang7CodeGen10CodeGenPGO20assignRegionCountersENS_10GlobalDeclEPN4llvm8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN5clang7CodeGen10CodeGenPGO20assignRegionCountersENS_10GlobalDeclEPN4llvm8FunctionE")
  //</editor-fold>
  public void assignRegionCounters(GlobalDecl GD, Function /*P*/ Fn) {
    /*const*/ Decl /*P*/ D = GD.getDecl();
    boolean InstrumentRegions = CGM.getCodeGenOpts().hasProfileClangInstr();
    IndexedInstrProfReader /*P*/ PGOReader = CGM.getPGOReader();
    if (!InstrumentRegions && !(PGOReader != null)) {
      return;
    }
    if (D.isImplicit()) {
      return;
    }
    // Constructors and destructors may be represented by several functions in IR.
    // If so, instrument only base variant, others are implemented by delegation
    // to the base one, it would be counted twice otherwise.
    if (CGM.getTarget().getCXXABI().hasConstructorVariants()
       && ((isa_CXXConstructorDecl(GD.getDecl())
       && GD.getCtorType() != CXXCtorType.Ctor_Base)
       || (isa_CXXDestructorDecl(GD.getDecl())
       && GD.getDtorType() != CXXDtorType.Dtor_Base))) {
      return;
    }
    CGM.ClearUnusedCoverageMapping(D);
    setFuncName(Fn);
    
    mapRegionCounters(D);
    if (CGM.getCodeGenOpts().CoverageMapping) {
      emitCounterRegionMapping(D);
    }
    if ((PGOReader != null)) {
      final SourceManager /*&*/ SM = CGM.getContext().getSourceManager();
      loadRegionCounts(PGOReader, SM.isInMainFile(D.getLocation()));
      computeRegionCounts(D);
      applyFunctionAttributes(PGOReader, Fn);
    }
  }


  /// Emit a coverage mapping range with a counter zero
  /// for an unused declaration.
  /// Emit a coverage mapping range with a counter zero
  /// for an unused declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenPGO::emitEmptyCounterMapping">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 691,
   FQN="clang::CodeGen::CodeGenPGO::emitEmptyCounterMapping", NM="_ZN5clang7CodeGen10CodeGenPGO23emitEmptyCounterMappingEPKNS_4DeclEN4llvm9StringRefENS5_11GlobalValue12LinkageTypesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN5clang7CodeGen10CodeGenPGO23emitEmptyCounterMappingEPKNS_4DeclEN4llvm9StringRefENS5_11GlobalValue12LinkageTypesE")
  //</editor-fold>
  public void emitEmptyCounterMapping(/*const*/ Decl /*P*/ D, StringRef Name, 
                         GlobalValue.LinkageTypes Linkage) {
    raw_string_ostream OS = null;
    try {
      if (skipRegionMappingForDecl(D)) {
        return;
      }
      
      std.string CoverageMapping/*J*/= new std.string();
      OS/*J*/= new raw_string_ostream(CoverageMapping);
      CoverageMappingGen MappingGen/*J*/= new CoverageMappingGen(/*Deref*/CGM.getCoverageMapping(), 
          CGM.getContext().getSourceManager(), 
          CGM.getLangOpts());
      MappingGen.emitEmptyMapping(D, OS);
      OS.flush();
      if (CoverageMapping.empty()) {
        return;
      }
      
      setFuncName(new StringRef(Name), Linkage);
      CGM.getCoverageMapping().addFunctionMappingRecord(FuncNameVar, new StringRef(FuncName), FunctionHash, CoverageMapping, false);
    } finally {
      if (OS != null) { OS.$destroy(); }
    }
  }


  // Insert instrumentation or attach profile metadata at value sites
  // Insert instrumentation or attach profile metadata at value sites
  
  // This method either inserts a call to the profile run-time during
  // instrumentation or puts profile data into metadata for PGO use.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenPGO::valueProfile">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 753,
   FQN="clang::CodeGen::CodeGenPGO::valueProfile", NM="_ZN5clang7CodeGen10CodeGenPGO12valueProfileERNS0_11CGBuilderTyEjPN4llvm11InstructionEPNS4_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN5clang7CodeGen10CodeGenPGO12valueProfileERNS0_11CGBuilderTyEjPN4llvm11InstructionEPNS4_5ValueE")
  //</editor-fold>
  public void valueProfile(final CGBuilderTy /*&*/ Builder, /*uint32_t*/int ValueKind, 
              Instruction /*P*/ ValueSite, Value /*P*/ ValuePtr) {
    if (!EnableValueProfiling.$T()) {
      return;
    }
    if (!(ValuePtr != null) || !(ValueSite != null) || !(Builder.GetInsertBlock() != null)) {
      return;
    }
    if (isa_Constant(ValuePtr)) {
      return;
    }
    
    boolean InstrumentValueSites = CGM.getCodeGenOpts().hasProfileClangInstr();
    if (InstrumentValueSites && RegionCounterMap.$bool()) {
      IRBuilderBase.InsertPoint BuilderInsertPoint = Builder.saveIP();
      Builder.SetInsertPoint(ValueSite);
      Value /*P*/ Args[/*5*/] = new Value /*P*/  [/*5*/] {
        ConstantExpr.getBitCast(FuncNameVar, Builder.getInt8PtrTy()), 
        Builder.getInt64(FunctionHash), 
        Builder.CreatePtrToInt(ValuePtr, Builder.getInt64Ty()), 
        Builder.getInt32(ValueKind), 
        Builder.getInt32(NumValueSites.data()[ValueKind]++)
      };
      Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(CGM.getIntrinsic(ID.instrprof_value_profile), new ArrayRef<Value /*P*/ >(Args, true));
      Builder.restoreIP(new IRBuilderBase.InsertPoint(BuilderInsertPoint));
      return;
    }
    
    IndexedInstrProfReader /*P*/ PGOReader = CGM.getPGOReader();
    if ((PGOReader != null) && haveRegionCounts()) {
      // We record the top most called three functions at each call site.
      // Profile metadata contains "VP" string identifying this metadata
      // as value profiling data, then a uint32_t value for the value profiling
      // kind, a uint64_t value for the total number of times the call is
      // executed, followed by the function hash and execution count (uint64_t)
      // pairs for each function.
      if ($greatereq_uint(NumValueSites.data()[ValueKind], ProfRecord.$arrow().getNumValueSites(ValueKind))) {
        return;
      }
      
      annotateValueSite(CGM.getModule(), /*Deref*/ValueSite, ProfRecord.$star(), 
          InstrProfValueKind.valueOf(ValueKind), 
          NumValueSites.data()[ValueKind]);
      
      NumValueSites.data()[ValueKind]++;
    }
  }


/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenPGO::setFuncName">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 44,
   FQN="clang::CodeGen::CodeGenPGO::setFuncName", NM="_ZN5clang7CodeGen10CodeGenPGO11setFuncNameEPN4llvm8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN5clang7CodeGen10CodeGenPGO11setFuncNameEPN4llvm8FunctionE")
  //</editor-fold>
  private void setFuncName(Function /*P*/ Fn) {
    setFuncName(Fn.getName(), Fn.getLinkage());
    // Create PGOFuncName meta data.
    createPGOFuncNameMetadata(/*Deref*/Fn, new StringRef(FuncName));
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenPGO::setFuncName">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 32,
   FQN="clang::CodeGen::CodeGenPGO::setFuncName", NM="_ZN5clang7CodeGen10CodeGenPGO11setFuncNameEN4llvm9StringRefENS2_11GlobalValue12LinkageTypesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN5clang7CodeGen10CodeGenPGO11setFuncNameEN4llvm9StringRefENS2_11GlobalValue12LinkageTypesE")
  //</editor-fold>
  private void setFuncName(StringRef Name, 
             GlobalValue.LinkageTypes Linkage) {
    IndexedInstrProfReader /*P*/ PGOReader = CGM.getPGOReader();
    FuncName.$assignMove(getPGOFuncName(new StringRef(Name), Linkage, new StringRef(CGM.getCodeGenOpts().MainFileName), 
            (PGOReader != null) ? PGOReader.getVersion() : ProfVersion.CurrentVersion.getValue()));
    
    // If we're generating a profile, create a variable for the name.
    if (CGM.getCodeGenOpts().hasProfileClangInstr()) {
      FuncNameVar = createPGOFuncNameVar(CGM.getModule(), Linkage, new StringRef(FuncName));
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenPGO::mapRegionCounters">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 646,
   FQN="clang::CodeGen::CodeGenPGO::mapRegionCounters", NM="_ZN5clang7CodeGen10CodeGenPGO17mapRegionCountersEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN5clang7CodeGen10CodeGenPGO17mapRegionCountersEPKNS_4DeclE")
  //</editor-fold>
  private void mapRegionCounters(/*const*/ Decl /*P*/ D) {
    RegionCounterMap.reset(new DenseMapTypeUInt</*const*/ Stmt /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0));
    MapRegionCounters Walker/*J*/= new MapRegionCounters(RegionCounterMap.$star());
    {
      /*const*/ FunctionDecl /*P*/ FD = dyn_cast_or_null_FunctionDecl(D);
      if ((FD != null)) {
        Walker.TraverseDecl(((/*const_cast*/FunctionDecl /*P*/ )(FD)));
      } else {
        /*const*/ ObjCMethodDecl /*P*/ MD = dyn_cast_or_null_ObjCMethodDecl(D);
        if ((MD != null)) {
          Walker.TraverseDecl(((/*const_cast*/ObjCMethodDecl /*P*/ )(MD)));
        } else {
          /*const*/ BlockDecl /*P*/ BD = dyn_cast_or_null_BlockDecl(D);
          if ((BD != null)) {
            Walker.TraverseDecl(((/*const_cast*/BlockDecl /*P*/ )(BD)));
          } else {
            /*const*/ CapturedDecl /*P*/ CD = dyn_cast_or_null_CapturedDecl(D);
            if ((CD != null)) {
              Walker.TraverseDecl(((/*const_cast*/CapturedDecl /*P*/ )(CD)));
            }
          }
        }
      }
    }
    assert ($greater_uint(Walker.NextCounter, 0)) : "no entry counter mapped for decl";
    NumRegionCounters = Walker.NextCounter;
    FunctionHash = Walker.Hash._finalize();
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenPGO::computeRegionCounts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 713,
   FQN="clang::CodeGen::CodeGenPGO::computeRegionCounts", NM="_ZN5clang7CodeGen10CodeGenPGO19computeRegionCountsEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN5clang7CodeGen10CodeGenPGO19computeRegionCountsEPKNS_4DeclE")
  //</editor-fold>
  private void computeRegionCounts(/*const*/ Decl /*P*/ D) {
    ComputeRegionCounts Walker = null;
    try {
      StmtCountMap.reset(new DenseMapTypeULong</*const*/ Stmt /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0));
      Walker/*J*/= new ComputeRegionCounts(StmtCountMap.$star(), /*Deref*/this);
      {
        /*const*/ FunctionDecl /*P*/ FD = dyn_cast_or_null_FunctionDecl(D);
        if ((FD != null)) {
          Walker.VisitFunctionDecl(FD);
        } else {
          /*const*/ ObjCMethodDecl /*P*/ MD = dyn_cast_or_null_ObjCMethodDecl(D);
          if ((MD != null)) {
            Walker.VisitObjCMethodDecl(MD);
          } else {
            /*const*/ BlockDecl /*P*/ BD = dyn_cast_or_null_BlockDecl(D);
            if ((BD != null)) {
              Walker.VisitBlockDecl(BD);
            } else {
              /*const*/ CapturedDecl /*P*/ CD = dyn_cast_or_null_CapturedDecl(D);
              if ((CD != null)) {
                Walker.VisitCapturedDecl(((/*const_cast*/CapturedDecl /*P*/ )(CD)));
              }
            }
          }
        }
      }
    } finally {
      if (Walker != null) { Walker.$destroy(); }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenPGO::applyFunctionAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 726,
   FQN="clang::CodeGen::CodeGenPGO::applyFunctionAttributes", NM="_ZN5clang7CodeGen10CodeGenPGO23applyFunctionAttributesEPN4llvm22IndexedInstrProfReaderEPNS2_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN5clang7CodeGen10CodeGenPGO23applyFunctionAttributesEPN4llvm22IndexedInstrProfReaderEPNS2_8FunctionE")
  //</editor-fold>
  private void applyFunctionAttributes(IndexedInstrProfReader /*P*/ PGOReader, 
                         Function /*P*/ Fn) {
    if (!haveRegionCounts()) {
      return;
    }
    
    long/*uint64_t*/ FunctionCount = getRegionCount((/*const*/ Stmt /*P*/ )null);
    Fn.setEntryCount(FunctionCount);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenPGO::loadRegionCounts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 801,
   FQN="clang::CodeGen::CodeGenPGO::loadRegionCounts", NM="_ZN5clang7CodeGen10CodeGenPGO16loadRegionCountsEPN4llvm22IndexedInstrProfReaderEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN5clang7CodeGen10CodeGenPGO16loadRegionCountsEPN4llvm22IndexedInstrProfReaderEb")
  //</editor-fold>
  private void loadRegionCounts(IndexedInstrProfReader /*P*/ PGOReader, 
                  boolean IsInMainFile) {
    Expected<InstrProfRecord> RecordExpected = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      CGM.getPGOStats().addVisited(IsInMainFile);
      RegionCounts.clear();
      RecordExpected = PGOReader.getInstrProfRecord(new StringRef(FuncName), FunctionHash);
      {
        Error E = null;
        try {
          E = RecordExpected.takeError();
          if (E.$bool()) {
            instrprof_error IPE = $c$.clean(InstrProfError.take($c$.track(new Error(JD$Move.INSTANCE, std.move(E)))));
            if (IPE == instrprof_error.unknown_function) {
              CGM.getPGOStats().addMissing(IsInMainFile);
            } else if (IPE == instrprof_error.hash_mismatch) {
              CGM.getPGOStats().addMismatched(IsInMainFile);
            } else if (IPE == instrprof_error.malformed) {
              // TODO: Consider a more specific warning for this case.
              CGM.getPGOStats().addMismatched(IsInMainFile);
            }
            return;
          }
        } finally {
          if (E != null) { E.$destroy(); }
        }
      }
      $c$.clean(ProfRecord.$assignMove(
          $c$.track(llvm.make_unique(new InstrProfRecord(std.move(RecordExpected.get()))))
      ));
      RegionCounts.$assign(ProfRecord.$arrow().Counts);
    } finally {
      if (RecordExpected != null) { RecordExpected.$destroy(); }
      $c$.$destroy();
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenPGO::skipRegionMappingForDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 662,
   FQN="clang::CodeGen::CodeGenPGO::skipRegionMappingForDecl", NM="_ZN5clang7CodeGen10CodeGenPGO24skipRegionMappingForDeclEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN5clang7CodeGen10CodeGenPGO24skipRegionMappingForDeclEPKNS_4DeclE")
  //</editor-fold>
  private boolean skipRegionMappingForDecl(/*const*/ Decl /*P*/ D) {
    if (SkipCoverageMapping) {
      return true;
    }
    
    // Don't map the functions in system headers.
    final /*const*/ SourceManager /*&*/ SM = CGM.getContext().getSourceManager();
    SourceLocation Loc = D.getBody().getLocStart();
    return SM.isInSystemHeader(/*NO_COPY*/Loc);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenPGO::emitCounterRegionMapping">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 672,
   FQN="clang::CodeGen::CodeGenPGO::emitCounterRegionMapping", NM="_ZN5clang7CodeGen10CodeGenPGO24emitCounterRegionMappingEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN5clang7CodeGen10CodeGenPGO24emitCounterRegionMappingEPKNS_4DeclE")
  //</editor-fold>
  private void emitCounterRegionMapping(/*const*/ Decl /*P*/ D) {
    raw_string_ostream OS = null;
    try {
      if (skipRegionMappingForDecl(D)) {
        return;
      }
      
      std.string CoverageMapping/*J*/= new std.string();
      OS/*J*/= new raw_string_ostream(CoverageMapping);
      CoverageMappingGen MappingGen/*J*/= new CoverageMappingGen(/*Deref*/CGM.getCoverageMapping(), 
          CGM.getContext().getSourceManager(), 
          CGM.getLangOpts(), RegionCounterMap.get());
      MappingGen.emitCounterMapping(D, OS);
      OS.flush();
      if (CoverageMapping.empty()) {
        return;
      }
      
      CGM.getCoverageMapping().addFunctionMappingRecord(FuncNameVar, new StringRef(FuncName), FunctionHash, CoverageMapping);
    } finally {
      if (OS != null) { OS.$destroy(); }
    }
  }


/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenPGO::emitCounterIncrement">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 736,
   FQN="clang::CodeGen::CodeGenPGO::emitCounterIncrement", NM="_ZN5clang7CodeGen10CodeGenPGO20emitCounterIncrementERNS0_11CGBuilderTyEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN5clang7CodeGen10CodeGenPGO20emitCounterIncrementERNS0_11CGBuilderTyEPKNS_4StmtE")
  //</editor-fold>
  public void emitCounterIncrement(final CGBuilderTy /*&*/ Builder, /*const*/ Stmt /*P*/ S) {
    if (!CGM.getCodeGenOpts().hasProfileClangInstr() || !RegionCounterMap.$bool()) {
      return;
    }
    if (!(Builder.GetInsertBlock() != null)) {
      return;
    }
    
    /*uint*/int Counter = (RegionCounterMap.$star()).$at_T1$C$R(S);
    org.llvm.ir.PointerType /*P*/ I8PtrTy = org.llvm.ir.Type.getInt8PtrTy(CGM.getLLVMContext());
    Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(CGM.getIntrinsic(ID.instrprof_increment), 
        /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*4*/] {
              ConstantExpr.getBitCast(FuncNameVar, I8PtrTy), 
              Builder.getInt64(FunctionHash), 
              Builder.getInt32(NumRegionCounters), 
              Builder.getInt32(Counter)}, true)/* }*/);
  }


  
  /// Return the region count for the counter at the given index.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenPGO::getRegionCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.h", line = 113,
   FQN="clang::CodeGen::CodeGenPGO::getRegionCount", NM="_ZN5clang7CodeGen10CodeGenPGO14getRegionCountEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen10CodeGenPGO14getRegionCountEPKNS_4StmtE")
  //</editor-fold>
  public long/*uint64_t*/ getRegionCount(/*const*/ Stmt /*P*/ S) {
    if (!RegionCounterMap.$bool()) {
      return $int2ulong(0);
    }
    if (!haveRegionCounts()) {
      return $int2ulong(0);
    }
    return RegionCounts.$at((RegionCounterMap.$star()).$at_T1$C$R(S));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenPGO::~CodeGenPGO">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.h", line = 31,
   FQN="clang::CodeGen::CodeGenPGO::~CodeGenPGO", NM="_ZN5clang7CodeGen10CodeGenPGOD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen10CodeGenPGOD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    RegionCounts.$destroy();
    ProfRecord.$destroy();
    StmtCountMap.$destroy();
    RegionCounterMap.$destroy();
    FuncName.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "CGM=" + CGM // NOI18N
              + ", FuncName=" + FuncName // NOI18N
              + ", FuncNameVar=" + FuncNameVar // NOI18N
              + ", NumValueSites=" + NumValueSites // NOI18N
              + ", NumRegionCounters=" + NumRegionCounters // NOI18N
              + ", FunctionHash=" + FunctionHash // NOI18N
              + ", RegionCounterMap=" + RegionCounterMap // NOI18N
              + ", StmtCountMap=" + StmtCountMap // NOI18N
              + ", ProfRecord=" + ProfRecord // NOI18N
              + ", RegionCounts=" + RegionCounts // NOI18N
              + ", CurrentRegionCount=" + CurrentRegionCount // NOI18N
              + ", SkipCoverageMapping=" + SkipCoverageMapping; // NOI18N
  }
}
