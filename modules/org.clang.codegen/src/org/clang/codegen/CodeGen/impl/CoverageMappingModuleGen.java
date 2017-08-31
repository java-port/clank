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
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.llvm.profiledata.coverage.*;
import org.clang.codegen.impl.*;
import static org.clang.codegen.impl.CoverageMappingGenStatics.*;
import org.clank.support.aliases.type$ptr;
import static org.llvm.profiledata.IndexedInstrProf.IndexedInstrProfGlobals.*;
import static org.llvm.profiledata.impl.InstrProfLlvmGlobals.*;
import org.llvm.support.sys.fs;


/// \brief Organizes the cross-function state that is used while generating
/// code coverage mapping data.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CoverageMappingModuleGen">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.h", line = 52,
 FQN="clang::CodeGen::CoverageMappingModuleGen", NM="_ZN5clang7CodeGen24CoverageMappingModuleGenE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen24CoverageMappingModuleGenE")
//</editor-fold>
public class CoverageMappingModuleGen implements Destructors.ClassWithDestructor {
  private final CodeGenModule /*&*/ CGM;
  private final CoverageSourceInfo /*&*/ SourceInfo;
  private SmallDenseMapTypeUInt</*const*/ FileEntry /*P*/ > FileEntries;
  private std.vector<Constant /*P*/ > FunctionRecords;
  private std.vector<Constant /*P*/ > FunctionNames;
  private StructType /*P*/ FunctionRecordTy;
  private std.vectorString CoverageMappings;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CoverageMappingModuleGen::CoverageMappingModuleGen">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.h", line = 62,
   FQN="clang::CodeGen::CoverageMappingModuleGen::CoverageMappingModuleGen", NM="_ZN5clang7CodeGen24CoverageMappingModuleGenC1ERNS0_13CodeGenModuleERNS_18CoverageSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen24CoverageMappingModuleGenC1ERNS0_13CodeGenModuleERNS_18CoverageSourceInfoE")
  //</editor-fold>
  public CoverageMappingModuleGen(final CodeGenModule /*&*/ CGM, final CoverageSourceInfo /*&*/ SourceInfo) {
    // : CGM(CGM), SourceInfo(SourceInfo), FileEntries(), FunctionRecords(), FunctionNames(), FunctionRecordTy(null), CoverageMappings() 
    //START JInit
    this./*&*/CGM=/*&*/CGM;
    this./*&*/SourceInfo=/*&*/SourceInfo;
    this.FileEntries = new SmallDenseMapTypeUInt</*const*/ FileEntry /*P*/ >(DenseMapInfo$LikePtr.$Info(), 8, (/*uint*/int)0);
    this.FunctionRecords = new std.vector<Constant /*P*/ >((Constant /*P*/ )null);
    this.FunctionNames = new std.vector<Constant /*P*/ >((Constant /*P*/ )null);
    this.FunctionRecordTy = null;
    this.CoverageMappings = new std.vectorString(std.string.EMPTY);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CoverageMappingModuleGen::getSourceInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.h", line = 65,
   FQN="clang::CodeGen::CoverageMappingModuleGen::getSourceInfo", NM="_ZNK5clang7CodeGen24CoverageMappingModuleGen13getSourceInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZNK5clang7CodeGen24CoverageMappingModuleGen13getSourceInfoEv")
  //</editor-fold>
  public CoverageSourceInfo /*&*/ getSourceInfo() /*const*/ {
    return SourceInfo;
  }

  
  /// \brief Add a function's coverage mapping record to the collection of the
  /// function mapping records.
  
  /// \brief Add a function's coverage mapping record to the collection of the
  /// function mapping records.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CoverageMappingModuleGen::addFunctionMappingRecord">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 971,
   FQN="clang::CodeGen::CoverageMappingModuleGen::addFunctionMappingRecord", NM="_ZN5clang7CodeGen24CoverageMappingModuleGen24addFunctionMappingRecordEPN4llvm14GlobalVariableENS2_9StringRefEyRKSsb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN5clang7CodeGen24CoverageMappingModuleGen24addFunctionMappingRecordEPN4llvm14GlobalVariableENS2_9StringRefEyRKSsb")
  //</editor-fold>
  public void addFunctionMappingRecord(GlobalVariable /*P*/ NamePtr, StringRef NameValue, long/*uint64_t*/ FuncHash, 
                          final /*const*/std.string/*&*/ CoverageMapping) {
    addFunctionMappingRecord(NamePtr, NameValue, FuncHash, 
                          CoverageMapping, true);
  }
  public void addFunctionMappingRecord(GlobalVariable /*P*/ NamePtr, StringRef NameValue, long/*uint64_t*/ FuncHash, 
                          final /*const*/std.string/*&*/ CoverageMapping, boolean IsUsed/*= true*/) {
    final LLVMContext /*&*/ Ctx = CGM.getLLVMContext();
    if (!(FunctionRecordTy != null)) {
      org.llvm.ir.Type /*P*/ FunctionRecordTypes[/*3*/] = new org.llvm.ir.Type /*P*/  [/*3*/] {
        org.llvm.ir.Type.getInt64Ty(Ctx), 
        org.llvm.ir.Type.getInt32Ty(Ctx), 
        org.llvm.ir.Type.getInt64Ty(Ctx)
      };
      FunctionRecordTy
         = StructType.get(Ctx, makeArrayRef(FunctionRecordTypes, true), 
          /*isPacked=*/ true);
    }
    Constant /*P*/ FunctionRecordVals[/*3*/] = new Constant /*P*/  [/*3*/] {
      ConstantInt.get(org.llvm.ir.Type.getInt64Ty(Ctx), ComputeHash(new StringRef(NameValue))), 
      ConstantInt.get(org.llvm.ir.Type.getInt32Ty(Ctx), $uint2ulong(CoverageMapping.size())), 
      ConstantInt.get(org.llvm.ir.Type.getInt64Ty(Ctx), FuncHash)
    };
    FunctionRecords.push_back_T$RR(ConstantStruct.get(FunctionRecordTy, makeArrayRef(FunctionRecordVals, true)));
    if (!IsUsed) {
      FunctionNames.push_back_T$RR(ConstantExpr.getBitCast(NamePtr, org.llvm.ir.Type.getInt8PtrTy(Ctx)));
    }
    CoverageMappings.push_back_T$C$R(CoverageMapping);
    if (CGM.getCodeGenOpts().DumpCoverageMapping) {
      std.vector<StringRef> Filenames = null;
      std.vector<CounterExpression> Expressions = null;
      std.vector<CounterMappingRegion> Regions = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Dump the coverage mapping data for this function by decoding the
        // encoded data. This allows us to dump the mapping regions which were
        // also processed by the CoverageMappingWriter which performs
        // additional minimization operations such as reducing the number of
        // expressions.
        Filenames/*J*/= new std.vector<StringRef>(new StringRef());
        Expressions/*J*/= new std.vector<CounterExpression>(new CounterExpression());
        Regions/*J*/= new std.vector<CounterMappingRegion>(new CounterMappingRegion());
        SmallVector<StringRef> FilenameRefs/*J*/= new SmallVector<StringRef>(16, new StringRef());
        FilenameRefs.resize(FileEntries.size());
        for (pairTypeUInt<FileEntry> Entry : FileEntries)  {
          FilenameRefs.$at(Entry.second).$assignMove(/*STRINGREF_STR*/Entry.first.getName());
        }
        RawCoverageMappingReader Reader/*J*/= new RawCoverageMappingReader(new StringRef(CoverageMapping), new ArrayRef<StringRef>(FilenameRefs, false), Filenames, 
            Expressions, Regions);
        if ($c$.clean($c$.track(Reader.read()).$bool())) {
          return;
        }
        CoverageMappingGenStatics.dump(llvm.outs(), new StringRef(NameValue), new ArrayRef<CounterExpression>(Expressions, false), new ArrayRef<CounterMappingRegion>(Regions, false));
      } finally {
        if (Regions != null) { Regions.$destroy(); }
        if (Expressions != null) { Expressions.$destroy(); }
        if (Filenames != null) { Filenames.$destroy(); }
        $c$.$destroy();
      }
    }
  }


  
  /// \brief Emit the coverage mapping data for a translation unit.
  
  /// \brief Emit the coverage mapping data for a translation unit.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CoverageMappingModuleGen::emit">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 1017,
   FQN="clang::CodeGen::CoverageMappingModuleGen::emit", NM="_ZN5clang7CodeGen24CoverageMappingModuleGen4emitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN5clang7CodeGen24CoverageMappingModuleGen4emitEv")
  //</editor-fold>
  public void emit() {
    raw_string_ostream OS = null;
    try {
      if (FunctionRecords.empty()) {
        return;
      }
      final LLVMContext /*&*/ Ctx = CGM.getLLVMContext();
      IntegerType /*P*/ Int32Ty = org.llvm.ir.Type.getInt32Ty(Ctx);
      
      // Create the filenames and merge them with coverage mappings
      SmallVector<std.string> FilenameStrs/*J*/= new SmallVector<std.string>(16, new std.string());
      SmallVector<StringRef> FilenameRefs/*J*/= new SmallVector<StringRef>(16, new StringRef());
      FilenameStrs.resize(FileEntries.size());
      FilenameRefs.resize(FileEntries.size());
      for (pairTypeUInt<FileEntry> Entry : FileEntries) {
                SmallString/*<256>*/ Path/*J*/= new SmallString/*<256>*/(256, new StringRef(Entry.first.getName()));
        fs.make_absolute(Path);
        
        /*uint*/int I = Entry.second;
        FilenameStrs.$at(I).$assignMove(new std.string(Path.begin(), Path.end()));
        FilenameRefs.$at(I).$assignMove(new StringRef(FilenameStrs.$at(I)));
      }
      
      std.string FilenamesAndCoverageMappings/*J*/= new std.string();
      OS/*J*/= new raw_string_ostream(FilenamesAndCoverageMappings);
      new CoverageFilenamesSectionWriter(new ArrayRef<StringRef>(FilenameRefs, false)).write(OS);
      std.string RawCoverageMappings = llvm.join(CoverageMappings.begin(), CoverageMappings.end(), new StringRef(/*KEEP_STR*/$EMPTY));
      OS.$out(RawCoverageMappings);
      /*size_t*/int CoverageMappingSize = RawCoverageMappings.size();
      /*size_t*/int FilenamesSize = OS.str().size() - CoverageMappingSize;
      {
        // Append extra zeroes if necessary to ensure that the size of the filenames
        // and coverage mappings is a multiple of 8.
        /*size_t*/int Rem = $rem_uint(OS.str().size(), 8);
        if ((Rem != 0)) {
          CoverageMappingSize += 8 - Rem;
          for (/*size_t*/int I = 0, S = 8 - Rem; $less_uint(I, S); ++I)  {
            OS.$out_char($$TERM);
          }
        }
      }
      Constant /*P*/ FilenamesAndMappingsVal = ConstantDataArray.getString(Ctx, new StringRef(OS.str()), false);
      
      // Create the deferred function records array
      org.llvm.ir.ArrayType /*P*/ RecordsTy = org.llvm.ir.ArrayType.get(FunctionRecordTy, $uint2ulong(FunctionRecords.size()));
      Constant /*P*/ RecordsVal = ConstantArray.get(RecordsTy, new ArrayRef<Constant /*P*/ >(FunctionRecords, true));
      
      org.llvm.ir.Type /*P*/ CovDataHeaderTypes[/*4*/] = new org.llvm.ir.Type /*P*/  [/*4*/] {
        Int32Ty, 
        Int32Ty, 
        Int32Ty, 
        Int32Ty
      };
      StructType /*P*/ CovDataHeaderTy = StructType.get(Ctx, makeArrayRef(CovDataHeaderTypes, true));
      Constant /*P*/ CovDataHeaderVals[/*4*/] = new Constant /*P*/  [/*4*/] {
        ConstantInt.get(Int32Ty, $uint2ulong(FunctionRecords.size())), 
        ConstantInt.get(Int32Ty, $uint2ulong(FilenamesSize)), 
        ConstantInt.get(Int32Ty, $uint2ulong(CoverageMappingSize)), 
        ConstantInt.get(Int32Ty, CovMapVersion.CurrentVersion.getValue())
      };
      Constant /*P*/ CovDataHeaderVal = ConstantStruct.get(CovDataHeaderTy, makeArrayRef(CovDataHeaderVals, true));
      
      // Create the coverage data record
      org.llvm.ir.Type /*P*/ CovDataTypes[/*3*/] = new org.llvm.ir.Type /*P*/  [/*3*/] {
        CovDataHeaderTy, RecordsTy, 
        FilenamesAndMappingsVal.getType()};
      StructType /*P*/ CovDataTy = StructType.get(Ctx, makeArrayRef(CovDataTypes));
      Constant /*P*/ TUDataVals[/*3*/] = new Constant /*P*/  [/*3*/] {
        CovDataHeaderVal, RecordsVal, 
        FilenamesAndMappingsVal};
      Constant /*P*/ CovDataVal = ConstantStruct.get(CovDataTy, makeArrayRef(TUDataVals, true));
      GlobalVariable /*P*/ CovData = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
          return new GlobalVariable(CGM.getModule(), CovDataTy, true, GlobalValue.LinkageTypes.InternalLinkage, 
                  CovDataVal, new Twine(getCoverageMappingVarName()));
       });
      
      CovData.setSection(CoverageMappingGenStatics.getCoverageSection(CGM));
      CovData.setAlignment(8);
      
      // Make sure the data doesn't get deleted.
      CGM.addUsedGlobal(CovData);
      // Create the deferred function records array
      if (!FunctionNames.empty()) {
        org.llvm.ir.ArrayType /*P*/ NamesArrTy = org.llvm.ir.ArrayType.get(org.llvm.ir.Type.getInt8PtrTy(Ctx), 
            $uint2ulong(FunctionNames.size()));
        Constant /*P*/ NamesArrVal = ConstantArray.get(NamesArrTy, new ArrayRef<Constant /*P*/ >(FunctionNames, true));
        // This variable will *NOT* be emitted to the object file. It is used
        // to pass the list of names referenced to codegen.
        /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
            return new GlobalVariable(CGM.getModule(), NamesArrTy, true, 
                    GlobalValue.LinkageTypes.InternalLinkage, NamesArrVal, 
                    new Twine(getCoverageUnusedNamesVarName()));
         });
      }
    } finally {
      if (OS != null) { OS.$destroy(); }
    }
  }


  
  /// \brief Return the coverage mapping translation unit file id
  /// for the given file.
  
  /// \brief Return the coverage mapping translation unit file id
  /// for the given file.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CoverageMappingModuleGen::getFileID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 1103,
   FQN="clang::CodeGen::CoverageMappingModuleGen::getFileID", NM="_ZN5clang7CodeGen24CoverageMappingModuleGen9getFileIDEPKNS_9FileEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN5clang7CodeGen24CoverageMappingModuleGen9getFileIDEPKNS_9FileEntryE")
  //</editor-fold>
  public /*uint*/int getFileID(/*const*/ FileEntry /*P*/ File) {
    DenseMapIteratorTypeUInt</*const*/ FileEntry /*P*/ /*P*/> It = FileEntries.find(File);
    if (It.$noteq(/*NO_ITER_COPY*/FileEntries.end())) {
      return It.$arrow().second;
    }
    /*uint*/int FileID = FileEntries.size();
    FileEntries.insert_pair$KeyT$ValueT(std.make_pair_Ptr_uint(File, FileID));
    return FileID;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CoverageMappingModuleGen::~CoverageMappingModuleGen">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.h", line = 52,
   FQN="clang::CodeGen::CoverageMappingModuleGen::~CoverageMappingModuleGen", NM="_ZN5clang7CodeGen24CoverageMappingModuleGenD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen24CoverageMappingModuleGenD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    CoverageMappings.$destroy();
    FunctionNames.$destroy();
    FunctionRecords.$destroy();
    FileEntries.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "CGM=" + CGM // NOI18N
              + ", SourceInfo=" + SourceInfo // NOI18N
              + ", FileEntries=" + FileEntries // NOI18N
              + ", FunctionRecords=" + FunctionRecords // NOI18N
              + ", FunctionNames=" + FunctionNames // NOI18N
              + ", FunctionRecordTy=" + FunctionRecordTy // NOI18N
              + ", CoverageMappings=" + CoverageMappings; // NOI18N
  }
}
