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

package org.clang.codegen.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.io.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.impl.*;
import org.clang.codegen.CodeGen.impl.*;
import static org.clang.ast.CharUnitsGlobals.*;
import static org.clang.codegen.impl.CGObjCMacStatics.*;
import org.clang.codegen.java.ClangCodeGenFunctionPointers.FieldDecl2CharUnits;


/// A helper class for building GC layout strings.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IvarLayoutBuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 2020,
 FQN="(anonymous namespace)::IvarLayoutBuilder", NM="_ZN12_GLOBAL__N_117IvarLayoutBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_117IvarLayoutBuilderE")
//</editor-fold>
public class IvarLayoutBuilder implements Destructors.ClassWithDestructor {
  private final CodeGenModule /*&*/ CGM;
  
  /// The start of the layout.  Offsets will be relative to this value,
  /// and entries less than this value will be silently discarded.
  private CharUnits InstanceBegin;
  
  /// The end of the layout.  Offsets will never exceed this value.
  private CharUnits InstanceEnd;
  
  /// Whether we're generating the strong layout or the weak layout.
  private boolean ForStrongLayout;
  
  /// Whether the offsets in IvarsInfo might be out-of-order.
  private boolean IsDisordered/* = false*/;
  
  private SmallVector<IvarInfo> IvarsInfo;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IvarLayoutBuilder::IvarLayoutBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 2039,
   FQN="(anonymous namespace)::IvarLayoutBuilder::IvarLayoutBuilder", NM="_ZN12_GLOBAL__N_117IvarLayoutBuilderC1ERN5clang7CodeGen13CodeGenModuleENS1_9CharUnitsES5_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_117IvarLayoutBuilderC1ERN5clang7CodeGen13CodeGenModuleENS1_9CharUnitsES5_b")
  //</editor-fold>
  public IvarLayoutBuilder(final CodeGenModule /*&*/ CGM, CharUnits instanceBegin, 
      CharUnits instanceEnd, boolean forStrongLayout) {
    // : CGM(CGM), InstanceBegin(instanceBegin), InstanceEnd(instanceEnd), ForStrongLayout(forStrongLayout), IsDisordered(false), IvarsInfo() 
    //START JInit
    this./*&*/CGM=/*&*/CGM;
    this.InstanceBegin = new CharUnits(instanceBegin);
    this.InstanceEnd = new CharUnits(instanceEnd);
    this.ForStrongLayout = forStrongLayout;
    /*InClass*/this.IsDisordered = false;
    this.IvarsInfo = new SmallVector<IvarInfo>(8, new IvarInfo());
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IvarLayoutBuilder::visitRecord">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 4735,
   FQN="(anonymous namespace)::IvarLayoutBuilder::visitRecord", NM="_ZN12_GLOBAL__N_117IvarLayoutBuilder11visitRecordEPKN5clang10RecordTypeENS1_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_117IvarLayoutBuilder11visitRecordEPKN5clang10RecordTypeENS1_9CharUnitsE")
  //</editor-fold>
  public void visitRecord(/*const*/ RecordType /*P*/ RT, 
             CharUnits offset) {
    /*const*/ RecordDecl /*P*/ RD = RT.getDecl();
    
    // If this is a union, remember that we had one, because it might mess
    // up the ordering of layout entries.
    if (RD.isUnion()) {
      IsDisordered = true;
    }
    
    /*const*/ final type$ptr<ASTRecordLayout> /*P*/ recLayout = create_type$ptr();
    visitAggregate(RD.field_begin(), RD.field_end(), new CharUnits(offset), 
        /*[&, &recLayout, this, &RD]*/ (/*const*/ FieldDecl /*P*/ field) -> {
              if (!(recLayout.$star() != null)) {
                recLayout.$set(/*AddrOf*/CGM.getContext().getASTRecordLayout(RD));
              }
              long/*uint64_t*/ offsetInBits = recLayout.$arrow().getFieldOffset(field.getFieldIndex());
              return CGM.getContext().toCharUnitsFromBits(offsetInBits);
            });
  }

  
  /*template <class Iterator, class GetOffsetFn> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IvarLayoutBuilder::visitAggregate">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 4755,
   FQN="(anonymous namespace)::IvarLayoutBuilder::visitAggregate", NM="Tpl__ZN12_GLOBAL__N_117IvarLayoutBuilder14visitAggregateET_S1_N5clang9CharUnitsERKT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=Tpl__ZN12_GLOBAL__N_117IvarLayoutBuilder14visitAggregateET_S1_N5clang9CharUnitsERKT0_")
  //</editor-fold>
  public <T extends FieldDecl, /*class*/ Iterator extends type$iterator<?, T>, /*class*/ GetOffsetFn extends FieldDecl2CharUnits> void visitAggregate(Iterator begin, Iterator end, 
                CharUnits aggregateOffset, 
                final /*const*/ GetOffsetFn /*&*/ getOffset) {
    for (; Native.$noteq(begin, end); begin.$preInc()) {
      /*<dependent type>*/FieldDecl field = Native.$star(begin);
      
      // Skip over bitfields.
      if (field.isBitField()) {
        continue;
      }
      
      // Compute the offset of the field within the aggregate.
      CharUnits fieldOffset = aggregateOffset.$add(getOffset.$call(field));
      
      visitField(field, fieldOffset);
    }
  }

  
  
  /// Collect layout information for the given fields into IvarsInfo.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IvarLayoutBuilder::visitField">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 4774,
   FQN="(anonymous namespace)::IvarLayoutBuilder::visitField", NM="_ZN12_GLOBAL__N_117IvarLayoutBuilder10visitFieldEPKN5clang9FieldDeclENS1_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_117IvarLayoutBuilder10visitFieldEPKN5clang9FieldDeclENS1_9CharUnitsE")
  //</editor-fold>
  public void visitField(/*const*/ FieldDecl /*P*/ field, 
            CharUnits fieldOffset) {
    QualType fieldType = field.getType();
    
    // Drill down into arrays.
    long/*uint64_t*/ numElts = $int2ulong(1);
    {
      /*const*/ ConstantArrayType /*P*/ arrayType;
      while (((/*P*/ arrayType = CGM.getContext().getAsConstantArrayType(new QualType(fieldType))) != null)) {
        numElts *= arrayType.getSize().getZExtValue();
        fieldType.$assignMove(arrayType.getElementType());
      }
    }
    assert (!fieldType.$arrow().isArrayType()) : "ivar of non-constant array type?";
    
    // If we ended up with a zero-sized array, we've done what we can do within
    // the limits of this layout encoding.
    if (numElts == $int2ullong(0)) {
      return;
    }
    {
      
      // Recurse if the base element type is a record type.
      /*const*/ RecordType /*P*/ recType = fieldType.$arrow().getAs$RecordType();
      if ((recType != null)) {
        /*size_t*/int oldEnd = IvarsInfo.size();
        
        visitRecord(recType, new CharUnits(fieldOffset));
        
        // If we have an array, replicate the first entry's layout information.
        /*uint*/int numEltEntries = IvarsInfo.size() - oldEnd;
        if (numElts != $int2ullong(1) && numEltEntries != 0) {
          CharUnits eltSize = CGM.getContext().getTypeSizeInChars(recType);
          for (long/*uint64_t*/ eltIndex = $int2ulong(1); eltIndex != numElts; ++eltIndex) {
            // Copy the last numEltEntries onto the end of the array, adjusting
            // each for the element size.
            for (/*size_t*/int i = 0; i != numEltEntries; ++i) {
              IvarInfo firstEntry = new IvarInfo(IvarsInfo.$at(oldEnd + i));
              IvarsInfo.push_back(new IvarInfo(firstEntry.Offset.$add($star_long_CharUnits$C(eltIndex, eltSize)), 
                      firstEntry.SizeInWords));
            }
          }
        }
        
        return;
      }
    }
    
    // Classify the element type.
    Qualifiers.GC GCAttr = GetGCAttrTypeForType(CGM.getContext(), new QualType(fieldType));
    
    // If it matches what we're looking for, add an entry.
    if ((ForStrongLayout && GCAttr == Qualifiers.GC.Strong)
       || (!ForStrongLayout && GCAttr == Qualifiers.GC.Weak)) {
      assert (CGM.getContext().getTypeSizeInChars(/*NO_COPY*/fieldType).$eq(CGM.getPointerSize()));
      IvarsInfo.push_back(new IvarInfo(new CharUnits(fieldOffset), numElts));
    }
  }

  
  /// Add the layout of a block implementation.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IvarLayoutBuilder::visitBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 2100,
   FQN="(anonymous namespace)::IvarLayoutBuilder::visitBlock", NM="_ZN12_GLOBAL__N_117IvarLayoutBuilder10visitBlockERKN5clang7CodeGen11CGBlockInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_117IvarLayoutBuilder10visitBlockERKN5clang7CodeGen11CGBlockInfoE")
  //</editor-fold>
  public void visitBlock(final /*const*/ CGBlockInfo /*&*/ blockInfo) {
    // __isa is the first field in block descriptor and must assume by runtime's
    // convention that it is GC'able.
    IvarsInfo.push_back(new IvarInfo(CharUnits.Zero(), $int2ulong(1)));
    
    /*const*/ BlockDecl /*P*/ blockDecl = blockInfo.getBlockDecl();
    
    // Ignore the optional 'this' capture: C++ objects are not assumed
    // to be GC'ed.
    CharUnits lastFieldOffset/*J*/= new CharUnits();
    
    // Walk the captured variables.
    for (final /*const*/ BlockDecl.Capture /*&*/ CI : blockDecl.captures()) {
      /*const*/ VarDecl /*P*/ variable = CI.getVariable();
      QualType type = variable.getType();
      
      final /*const*/ CGBlockInfo.Capture /*&*/ capture = blockInfo.getCapture$Const(variable);
      
      // Ignore constant captures.
      if (capture.isConstant()) {
        continue;
      }
      
      CharUnits fieldOffset = capture.getOffset();
      
      // Block fields are not necessarily ordered; if we detect that we're
      // adding them out-of-order, make sure we sort later.
      if (fieldOffset.$less(lastFieldOffset)) {
        IsDisordered = true;
      }
      lastFieldOffset.$assign(fieldOffset);
      
      // __block variables are passed by their descriptor address.
      if (CI.isByRef()) {
        IvarsInfo.push_back(new IvarInfo(new CharUnits(fieldOffset), /*size in words*/ $int2ulong(1)));
        continue;
      }
      assert (!type.$arrow().isArrayType()) : "array variable should not be caught";
      {
        /*const*/ RecordType /*P*/ record = type.$arrow().getAs$RecordType();
        if ((record != null)) {
          visitRecord(record, new CharUnits(fieldOffset));
          continue;
        }
      }
      
      Qualifiers.GC GCAttr = GetGCAttrTypeForType(CGM.getContext(), new QualType(type));
      if (GCAttr == Qualifiers.GC.Strong) {
        assert (CGM.getContext().getTypeSize(new QualType(type)) == CGM.getTarget().getPointerWidth(0));
        IvarsInfo.push_back(new IvarInfo(new CharUnits(fieldOffset), /*size in words*/ $int2ulong(1)));
      }
    }
  }

  
  /// Is there any information for an interesting bitmap?
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IvarLayoutBuilder::hasBitmapData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 2058,
   FQN="(anonymous namespace)::IvarLayoutBuilder::hasBitmapData", NM="_ZNK12_GLOBAL__N_117IvarLayoutBuilder13hasBitmapDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZNK12_GLOBAL__N_117IvarLayoutBuilder13hasBitmapDataEv")
  //</editor-fold>
  public boolean hasBitmapData() /*const*/ {
    return !IvarsInfo.empty();
  }

  
  
  /// buildBitmap - This routine does the horsework of taking the offsets of
  /// strong/weak references and creating a bitmap.  The bitmap is also
  /// returned in the given buffer, suitable for being passed to \c dump().
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IvarLayoutBuilder::buildBitmap">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 4830,
   FQN="(anonymous namespace)::IvarLayoutBuilder::buildBitmap", NM="_ZN12_GLOBAL__N_117IvarLayoutBuilder11buildBitmapERNS_15CGObjCCommonMacERN4llvm15SmallVectorImplIhEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_117IvarLayoutBuilder11buildBitmapERNS_15CGObjCCommonMacERN4llvm15SmallVectorImplIhEE")
  //</editor-fold>
  public Constant /*P*/ buildBitmap(final CGObjCCommonMac /*&*/ CGObjC, 
             final SmallVectorImplUChar /*&*/ buffer) {
    // The bitmap is a series of skip/scan instructions, aligned to word
    // boundaries.  The skip is performed first.
    /*const*//*uchar*/byte MaxNibble = $int2uchar(0xF);
    /*const*//*uchar*/byte SkipMask = $int2uchar(0xF0);
    /*const*//*uchar*/byte SkipShift = $int2uchar(4);
    /*const*//*uchar*/byte ScanMask = $int2uchar(0x0F);
    /*const*//*uchar*/byte ScanShift = $int2uchar(0);
    assert (!IvarsInfo.empty()) : "generating bitmap for no data";
    
    // Sort the ivar info on byte position in case we encounterred a
    // union nested in the ivar list.
    if (IsDisordered) {
      // This isn't a stable sort, but our algorithm should handle it fine.
      llvm.array_pod_sort(IvarsInfo.begin(), IvarsInfo.end());
    } else {
      assert (std.is_sorted(IvarsInfo.begin(), IvarsInfo.end()));
    }
    assert (IvarsInfo.back().Offset.$less(InstanceEnd));
    assert (buffer.empty());
    
    // Skip the next N words.
    Int2Void skip = /*[&, &buffer]*/ (/*uint*/int numWords) -> {
          assert ($greater_uint(numWords, 0));
          
          // Try to merge into the previous byte.  Since scans happen second, we
          // can't do this if it includes a scan.
          if (!buffer.empty() && !(($uchar2int(buffer.back()) & $uchar2int(ScanMask)) != 0)) {
            /*uint*/int lastSkip = $uchar2int(buffer.back()) >> $uchar2int(SkipShift);
            if ($less_uint_uchar(lastSkip, MaxNibble)) {
              /*uint*/int claimed = std.min_uint($uchar2uint(MaxNibble) - lastSkip, numWords);
              numWords -= claimed;
              lastSkip += claimed;
              buffer.ref$back().$set($uint2uchar((lastSkip << $uchar2int(SkipShift))));
            }
          }
          while ($greatereq_uint_uchar(numWords, MaxNibble)) {
            buffer.push_back($int2uchar($uchar2int(MaxNibble) << $uchar2int(SkipShift)));
            numWords -= $uchar2uint(MaxNibble);
          }
          if ((numWords != 0)) {
            buffer.push_back($uint2uchar(numWords << $uchar2int(SkipShift)));
          }
        };
    
    // Scan the next N words.
    Int2Void scan = /*[&, &buffer]*/ (/*uint*/int numWords) -> {
          assert ($greater_uint(numWords, 0));
          
          // Try to merge into the previous byte.  Since scans happen second, we can
          // do this even if it includes a skip.
          if (!buffer.empty()) {
            /*uint*/int lastScan = ($uchar2int(buffer.back()) & $uchar2int(ScanMask)) >> $uchar2int(ScanShift);
            if ($less_uint_uchar(lastScan, MaxNibble)) {
              /*uint*/int claimed = std.min_uint($uchar2uint(MaxNibble) - lastScan, numWords);
              numWords -= claimed;
              lastScan += claimed;
              buffer.ref$back().$set($uint2uchar(($uchar2int(buffer.back()) & $uchar2int(SkipMask)) | (lastScan << $uchar2int(ScanShift))));
            }
          }
          while ($greatereq_uint_uchar(numWords, MaxNibble)) {
            buffer.push_back($int2uchar($uchar2int(MaxNibble) << $uchar2int(ScanShift)));
            numWords -= $uchar2uint(MaxNibble);
          }
          if ((numWords != 0)) {
            buffer.push_back($uint2uchar(numWords << $uchar2int(ScanShift)));
          }
        };
    
    // One past the end of the last scan.
    /*uint*/int endOfLastScanInWords = 0;
    /*const*/ CharUnits WordSize = CGM.getPointerSize();
    
    // Consider all the scan requests.
    for (final IvarInfo /*&*/ request : IvarsInfo) {
      CharUnits beginOfScan = request.Offset.$sub(InstanceBegin);
      
      // Ignore scan requests that don't start at an even multiple of the
      // word size.  We can't encode them.
      if ((beginOfScan.$mod(WordSize)) != 0) {
        continue;
      }
      
      // Ignore scan requests that start before the instance start.
      // This assumes that scans never span that boundary.  The boundary
      // isn't the true start of the ivars, because in the fragile-ARC case
      // it's rounded up to word alignment, but the test above should leave
      // us ignoring that possibility.
      if (beginOfScan.isNegative()) {
        assert (request.Offset.$add($star_long_CharUnits$C(request.SizeInWords, WordSize)).$lesseq(InstanceBegin));
        continue;
      }
      
      /*uint*/int beginOfScanInWords = $long2uint(beginOfScan.$slash(WordSize));
      /*uint*/int endOfScanInWords = $ullong2uint($uint2ullong(beginOfScanInWords) + request.SizeInWords);
      
      // If the scan starts some number of words after the last one ended,
      // skip forward.
      if ($greater_uint(beginOfScanInWords, endOfLastScanInWords)) {
        skip.$call(beginOfScanInWords - endOfLastScanInWords);
        // Otherwise, start scanning where the last left off.
      } else {
        beginOfScanInWords = endOfLastScanInWords;
        
        // If that leaves us with nothing to scan, ignore this request.
        if ($greatereq_uint(beginOfScanInWords, endOfScanInWords)) {
          continue;
        }
      }
      
      // Scan to the end of the request.
      assert ($less_uint(beginOfScanInWords, endOfScanInWords));
      scan.$call(endOfScanInWords - beginOfScanInWords);
      endOfLastScanInWords = endOfScanInWords;
    }
    if (buffer.empty()) {
      return ConstantPointerNull.get(CGM.Unnamed_field9.Int8PtrTy);
    }
    
    // For GC layouts, emit a skip to the end of the allocation so that we
    // have precise information about the entire thing.  This isn't useful
    // or necessary for the ARC-style layout strings.
    if (CGM.getLangOpts().getGC() != LangOptions.GCMode.NonGC) {
      /*uint*/int lastOffsetInWords = $long2uint((InstanceEnd.$sub(InstanceBegin).$add(WordSize).$sub(CharUnits.One())).$slash(WordSize));
      if ($greater_uint(lastOffsetInWords, endOfLastScanInWords)) {
        skip.$call(lastOffsetInWords - endOfLastScanInWords);
      }
    }
    
    // Null terminate the string.
    buffer.push_back($int2uchar(0));
    
    boolean isNonFragileABI = CGObjC.isNonFragileABI();
    
    GlobalVariable /*P*/ Entry = CGObjC.CreateMetadataVar(new Twine(/*KEEP_STR*/"OBJC_CLASS_NAME_"), 
        ConstantDataArray.get_LLVMContext_ArrayRefUChar(CGM.getLLVMContext(), new ArrayRefUChar(buffer)), 
        new StringRef((isNonFragileABI ? $("__TEXT,__objc_classname,cstring_literals") : $("__TEXT,__cstring,cstring_literals"))), 
        CharUnits.One(), true);
    return getConstantGEP(CGM.getLLVMContext(), Entry, 0, 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IvarLayoutBuilder::dump">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 2063,
   FQN="(anonymous namespace)::IvarLayoutBuilder::dump", NM="_ZN12_GLOBAL__N_117IvarLayoutBuilder4dumpEN4llvm8ArrayRefIhEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_117IvarLayoutBuilder4dumpEN4llvm8ArrayRefIhEE")
  //</editor-fold>
  public static void dump(ArrayRefUChar buffer) {
    /*const*/uchar$ptr/*uchar P*/ s = $tryClone(buffer.data());
    for (/*uint*/int i = 0, e = buffer.size(); $less_uint(i, e); i++)  {
      if (!(($uchar2int(s.$at(i)) & 0xf0) != 0)) {
        printf(/*KEEP_STR*/"0x0%x%s", $uchar2int(s.$at(i)), $uchar2int(s.$at(i)) != 0 ? $COMMA_SPACE : $EMPTY);
      } else {
        printf(/*KEEP_STR*/"0x%x%s", $uchar2int(s.$at(i)), $uchar2int(s.$at(i)) != 0 ? $COMMA_SPACE : $EMPTY);
      }
    }
    printf(/*KEEP_STR*/"\n");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IvarLayoutBuilder::~IvarLayoutBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 2020,
   FQN="(anonymous namespace)::IvarLayoutBuilder::~IvarLayoutBuilder", NM="_ZN12_GLOBAL__N_117IvarLayoutBuilderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_117IvarLayoutBuilderD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    IvarsInfo.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "CGM=" + CGM // NOI18N
              + ", InstanceBegin=" + InstanceBegin // NOI18N
              + ", InstanceEnd=" + InstanceEnd // NOI18N
              + ", ForStrongLayout=" + ForStrongLayout // NOI18N
              + ", IsDisordered=" + IsDisordered // NOI18N
              + ", IvarsInfo=" + IvarsInfo; // NOI18N
  }
}
