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

package org.clang.basic.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.llvm.support.sys.fs;


//<editor-fold defaultstate="collapsed" desc="static type SourceManagerStatics">
@Converted(kind = Converted.Kind.MANUAL,
 cmd="jclank.sh -java-types-map=${SPUTNIK}/contrib/JConvert/llvmToClankType -java-imports=${SPUTNIK}/contrib/JConvert/llvmToClankImports -print ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -file-filter=${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp#1180;${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp#1211;${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp#1613;${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp#2030;${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp#1215; -static-type=SourceManagerStatics")
//</editor-fold>
public final class SourceManagerStatics {

public static final boolean CACHE_LINES_OFFSETS = Boolean.valueOf(System.getProperty("clank.cache.lines.offsets", "true"));

// isInvalid - Return the result of calling loc.isInvalid(), and
// if Invalid is not null, set its value to same.
/*template <typename LocType> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="isInvalid">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 1164,
 FQN="isInvalid", NM="Tpl__ZL9isInvalidT_Pb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=Tpl__ZL9isInvalidT_Pb")
//</editor-fold>
public static boolean isInvalid(SourceLocation Loc, bool$ptr/*bool P*/ Invalid) {
 return isInvalid(Loc.getRawEncoding(), Invalid); 
}
public static boolean isInvalid(/*SourceLocation*/int Loc, bool$ptr/*bool P*/ Invalid) {
  boolean MyInvalid = SourceLocation.isInvalid(Loc);
  if ((Invalid != null)) {
    Invalid.$set(MyInvalid);
  }
  return MyInvalid;
}
@Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 1164,
 FQN="isInvalid", NM="Tpl__ZL9isInvalidT_Pb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=Tpl__ZL9isInvalidT_Pb")
//</editor-fold>
public static boolean isInvalid(PresumedLoc Loc, bool$ptr/*bool P*/ Invalid) {
  boolean MyInvalid = Loc.isInvalid();
  if ((Invalid != null)) {
    Invalid.$set(MyInvalid);
  }
  return MyInvalid;
}

//<editor-fold defaultstate="collapsed" desc="ComputeLineNumbers">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 1200,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 1198,
 FQN="ComputeLineNumbers", NM="_ZL18ComputeLineNumbersRN5clang17DiagnosticsEngineEPNS_6SrcMgr12ContentCacheERN4llvm20BumpPtrAllocatorImplINS5_15MallocAllocatorELj4096ELj4096EEERKNS_13SourceManagerERb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZL18ComputeLineNumbersRN5clang17DiagnosticsEngineEPNS_6SrcMgr12ContentCacheERN4llvm20BumpPtrAllocatorImplINS5_15MallocAllocatorELj4096ELj4096EEERKNS_13SourceManagerERb")
//</editor-fold>
public static boolean ComputeLineNumbers(DiagnosticsEngine /*&*/ Diag, SrcMgr.ContentCache/*P*/ FI, BumpPtrAllocator /*&*/ Alloc, /*const*/SourceManager /*&*/ SM, bool$ptr/*bool &*/ Invalid)/* __attribute__((noinline))*/ {
  SmallVectorInt $LineOffsets = $getLineOffsets();
  boolean out = ComputeLineNumbers(Diag, FI, Alloc, SM, $LineOffsets, Invalid);
  $releaseLineOffsets($LineOffsets);
  return out;
}

private static boolean ComputeLineNumbers(DiagnosticsEngine /*&*/ Diag, SrcMgr.ContentCache/*P*/ FI, 
        BumpPtrAllocator /*&*/ Alloc, /*const*/SourceManager /*&*/ SM, 
        final SmallVectorInt LineOffsets,
        bool$ptr/*bool &*/ Invalid)/* __attribute__((noinline))*/ {
  assert Invalid == null : "use return value \"true\" as marker of invalid computation";
//  SmallVectorUInt LineOffsets = null;
//  try {//PERF: remove try/finally
    // Note that calling 'getBuffer()' may lazily page in the file.
    /*const*/MemoryBuffer /*P*/ Buffer = FI.getBuffer(Diag, SM, SourceLocation.getInvalid(), /*AddrOf*/Invalid);
    if (Buffer.isInvalid()) {
      return true;
    }
    
    // JAVA PERF: use cached offsets from buffer
    if (CACHE_LINES_OFFSETS) {
      FI.SourceLineCache = Buffer.getSourceLineCache();
      if (FI.SourceLineCache != null) {
        // we are done
        FI.NumLines = FI.SourceLineCache.length;
        return false;
      }
    }
    // Find the file offsets of all of the *physical* source lines.  This does
    // not look at trigraphs, escaped newlines, or anything else tricky.
    assert LineOffsets != null; // PERF: LineOffsets should be passed as parameter
    
    // Line #1 starts at char 0.
    LineOffsets.push_back(0);
    
    /*const*/char$ptr/*uchar P*/ $Buf = Buffer.getBufferStart();
    int Buf = 0; // start index in Buf
    /*const*/int/*uchar P*/ End = Buffer.getBufferEnd().$index() - $Buf.$index();
    /*uint*/int Offs = 0;
    while (true) {
      // Skip over the contents of the line.
      /*const*/int/*uchar P*/ NextBuf = Buf;
//#ifdef __SSE2_      
//      // Try to skip to the next newline using SSE instructions. This is very
//      // performance sensitive for programs with lots of diagnostics and in -E
//      // mode.
//      __m128i CRs = _mm_set1_epi8('\r');
//      __m128i LFs = _mm_set1_epi8('\n');
//      
//      // First fix up the alignment to 16 bytes.
//      while (((long/*uintptr_t*/)NextBuf & 0xF) != 0) {
//        if (NextBuf.$star() == '\n' || NextBuf.$star() == '\r' || NextBuf.$star() == '\x00') {
//          goto FoundSpecialChar;
//        }
//        NextBuf.$preInc();
//      }
//      
//      // Scan 16 byte chunks for '\r' and '\n'. Ignore '\0'.
//      while (NextBuf.$add(16).$lesseq(End)) {
//        /*const*/__m128i Chunk = (__attribute__((__vector_size__(2 * sizeof(long long)))) long long /*const*/ /*P*/ )NextBuf.$star();
//        __m128i Cmp = _mm_or_si128(_mm_cmpeq_epi8(Chunk, CRs), _mm_cmpeq_epi8(Chunk, LFs));
//        /*uint*/int Mask = _mm_movemask_epi8(Cmp);
//        
//        // If we found a newline, adjust the pointer and jump to the handling code.
//        if (Mask != 0) {
//          NextBuf += llvm.countTrailingZeros(Mask);
//          goto FoundSpecialChar;
//        }
//        NextBuf += 16;
//      }
//#endif // __SSE2_      
      while ($Buf.$at(NextBuf) != $$LF && $Buf.$at(NextBuf) != $$CR && $Buf.$at(NextBuf) != $$TERM) {
        ++NextBuf;
      }
//#ifdef __SSE2__
//FoundSpecialChar:
//#endif
      Offs += NextBuf - Buf;
      Buf = NextBuf;
      if ($Buf.$at(Buf) == $$LF || $Buf.$at(Buf) == $$CR) {
        // If this is \n\r or \r\n, skip both characters.
        if (($Buf.$at(Buf + 1) == $$LF || $Buf.$at(Buf + 1) == $$CR) && $Buf.$at(Buf) != $Buf.$at(Buf + 1)) {
          ++Offs; 
          ++Buf;
        }
        ++Offs; 
        ++Buf;
        assert Offs >= 0 : "must be unsigned int";
        LineOffsets.push_back(Offs);
      } else {
        // Otherwise, this is a null.  If end of file, exit.
        if (Buf == End) {
          break;
        }
        // Otherwise, skip the null.
        ++Offs; 
        ++Buf;
      }
    }
    
    // Copy the offsets into the FileInfo structure.
    FI.NumLines = LineOffsets.size();
    if (CACHE_LINES_OFFSETS) {
      FI.SourceLineCache = new$int(FI.NumLines);
    } else {
      // FIXME: introduce index field if plan to use int[] from Slabs
      int$ptr AllocateIntPtr = Alloc.AllocateInt(LineOffsets.size());
      assert AllocateIntPtr.$index() == 0 : "only zero-based arrays are supported (introduce index field if plan to use int[] from Slabs)";
      FI.SourceLineCache = AllocateIntPtr.$array();
      assert FI.NumLines == FI.SourceLineCache.length : "same size is expected " + FI.NumLines + " vs. " + FI.SourceLineCache.length;
    }
    if (false) {
      //std.copy(LineOffsets.begin(), LineOffsets.end(), FI.SourceLineCache);
    } else {
      // PERF:
      std.copy(LineOffsets.$array(), 0, LineOffsets.size(), FI.SourceLineCache, 0/*FI.SourceLineCache.$index()*/);
      if (CACHE_LINES_OFFSETS) {
        Buffer.setSourceLineCache(FI.SourceLineCache, FI.NumLines);
      }    
    }
//  } finally {
//    if (LineOffsets != null) { LineOffsets.$destroy(); }
//  }
    return false;
}


/// \brief Retrieve the inode for the given file entry, if possible.
///
/// This routine involves a system call, and therefore should only be used
/// in non-performance-critical code.
//<editor-fold defaultstate="collapsed" desc="getActualFileUID">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 1577,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 1570,
 FQN="getActualFileUID", NM="_ZL16getActualFileUIDPKN5clang9FileEntryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZL16getActualFileUIDPKN5clang9FileEntryE")
//</editor-fold>
public static Optional<fs.UniqueID> getActualFileUID(/*const*/org.clang.basic.FileEntry /*P*/ File) {
  if (!(File != null)) {
    return new Optional<fs.UniqueID>(NoneType.None);
  }
  
    fs.UniqueID ID/*J*/= new fs.UniqueID();
  if (((fs.getUniqueID(new Twine(File.getName()), ID).$Void2Void()) != null)) {
    return new Optional<fs.UniqueID>(NoneType.None);
  }
  
  return new Optional<fs.UniqueID>(JD$T$RR.INSTANCE, ID);
}


/// Given a decomposed source location, move it up the include/expansion stack
/// to the parent source location.  If this is possible, return the decomposed
/// version of the parent in Loc and return false.  If Loc is the top-level
/// entry, return true and don't modify it.
//<editor-fold defaultstate="collapsed" desc="MoveUpIncludeHierarchy">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 1995,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 1988,
 FQN="MoveUpIncludeHierarchy", NM="_ZL22MoveUpIncludeHierarchyRSt4pairIN5clang6FileIDEjERKNS0_13SourceManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZL22MoveUpIncludeHierarchyRSt4pairIN5clang6FileIDEjERKNS0_13SourceManagerE")
//</editor-fold>
public static boolean MoveUpIncludeHierarchy(std.pairIntUInt/*<FileID, uint>*//*&*/ Loc, /*const*/SourceManager /*&*/ SM) {
  long/*<FileID, uint>*/ UpperLoc = SM.getDecomposedIncludedLoc(Loc.first);
  if (FileID.isInvalid($first_FileID(UpperLoc))) {
    return true; // We reached the top.
  }
  
  Loc.$assign(UpperLoc);
  return false;
}

  private static final SmallVector<SmallVectorInt> $LineOffsetsPool = new SmallVector<SmallVectorInt>(2*Native.availableProcessors(), null);
  private static SmallVectorInt $getLineOffsets() {   
    synchronized ($LineOffsetsPool) {
      if (!$LineOffsetsPool.empty()) {
        return $LineOffsetsPool.pop_back_val();
      }      
    }
    return new SmallVectorInt(NativeMemory.Allocator.PageSize, 0);
  }
  
  private static void $releaseLineOffsets(SmallVectorInt LineOffsets) {
    LineOffsets.resize(0);
    synchronized ($LineOffsetsPool) {
      $LineOffsetsPool.push_back(LineOffsets);
    }
  }
} // END OF class SourceManagerStatics
