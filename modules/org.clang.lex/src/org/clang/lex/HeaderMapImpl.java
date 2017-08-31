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

package org.clang.lex;

import static org.clank.support.Native.$Deref;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.lex.*;
import static org.clang.lex.LexClangGlobals.*;
import static org.clang.lex.impl.HeaderMapStatics.HashHMapKey;
import static org.llvm.adt.NoneType.None;
import org.llvm.support.sys.sys;


/// Implementation for \a HeaderMap that doesn't depend on \a FileManager.
//<editor-fold defaultstate="collapsed" desc="clang::HeaderMapImpl">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderMap.h", line = 31,
 FQN="clang::HeaderMapImpl", NM="_ZN5clang13HeaderMapImplE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -nm=_ZN5clang13HeaderMapImplE")
//</editor-fold>
public class HeaderMapImpl implements Destructors.ClassWithDestructor {
  protected HeaderMapImpl() {}
  
  private std.unique_ptr</*const*/ MemoryBuffer> FileBuffer;
  private boolean NeedsBSwap;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderMapImpl::HeaderMapImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderMap.h", line = 36,
   FQN="clang::HeaderMapImpl::HeaderMapImpl", NM="_ZN5clang13HeaderMapImplC1ESt10unique_ptrIKN4llvm12MemoryBufferESt14default_deleteIS4_EEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -nm=_ZN5clang13HeaderMapImplC1ESt10unique_ptrIKN4llvm12MemoryBufferESt14default_deleteIS4_EEb")
  //</editor-fold>
  public HeaderMapImpl(std.unique_ptr</*const*/ MemoryBuffer> File, boolean NeedsBSwap) {
    /* : FileBuffer(std::move(File)), NeedsBSwap(NeedsBSwap)*/ 
    //START JInit
    this.FileBuffer = new std.unique_ptr</*const*/ MemoryBuffer>(JD$Move.INSTANCE, std.move(File));
    this.NeedsBSwap = NeedsBSwap;
    //END JInit
  }

  
  // Check for a valid header and extract the byte swap.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderMapImpl::checkHeader">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp", line = 65,
   FQN="clang::HeaderMapImpl::checkHeader", NM="_ZN5clang13HeaderMapImpl11checkHeaderERKN4llvm12MemoryBufferERb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -nm=_ZN5clang13HeaderMapImpl11checkHeaderERKN4llvm12MemoryBufferERb")
  //</editor-fold>
  public static boolean checkHeader(/*const*/ MemoryBuffer /*&*/ File, 
             bool$ref/*bool &*/ NeedsByteSwap) {
    if ($lesseq_uint(File.getBufferSize(), /*JAVA*/HMapHeader.$sizeof_HMapHeader())) {
      return false;
    }
    /*const*/char$ptr/*char P*/ FileStart = $noClone(File.getBufferStart());
    
    // We know the file is at least as big as the header, check it now.
//    /*const*/ HMapHeader /*P*/ Header = reinterpret_cast(/*const*/ HMapHeader /*P*/ .class, FileStart);
    /*const*/ HMapHeader/*P*/ Header = /*JAVA*/HMapHeader.reinterpret_cast(FileStart);
    
    // Sniff it to see if it's a headermap by checking the magic number and
    // version.
    if (Header.Magic == HMAP_HeaderMagicNumber
       && $ushort2int(Header.Version) == HMAP_HeaderVersion) {
      NeedsByteSwap.$set(false);
    } else if (Header.Magic == llvm.ByteSwap_32(HMAP_HeaderMagicNumber)
       && $ushort2int(Header.Version) == $ushort2int(llvm.ByteSwap_16($uint2ushort(HMAP_HeaderVersion)))) {
      NeedsByteSwap.$set(true); // Mixed endianness headermap.
    } else {
      return false; // Not a header map.
    }
    if ($ushort2int(Header.Reserved) != 0) {
      return false;
    }
    
    // Check the number of buckets.  It should be a power of two, and there
    // should be enough space in the file for all of them.
    /*uint32_t*/int NumBuckets = NeedsByteSwap.$deref() ? sys.getSwappedBytes_uint(Header.NumBuckets) : Header.NumBuckets;
    if (!llvm.isPowerOf2_32(NumBuckets)) {
      return false;
    }
    if ($less_uint(File.getBufferSize()
      , HMapHeader.$sizeof_HMapHeader() + HMapBucket.$sizeof_HMapBucket() * NumBuckets)) {
      return false;
    }
    
    // Okay, everything looks good.
    return true;
  }

  
  /// If the specified relative filename is located in this HeaderMap return
  /// the filename it is mapped to, otherwise return an empty StringRef.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderMapImpl::lookupFilename">
  @Converted(kind = Converted.Kind.MANUAL, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp", line = 210,
   FQN="clang::HeaderMapImpl::lookupFilename", NM="_ZNK5clang13HeaderMapImpl14lookupFilenameEN4llvm9StringRefERNS1_15SmallVectorImplIcEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -nm=_ZNK5clang13HeaderMapImpl14lookupFilenameEN4llvm9StringRefERNS1_15SmallVectorImplIcEE")
  //</editor-fold>
  public StringRef lookupFilename(StringRef Filename, 
                SmallString/*&*/ DestPath) /*const*/ {
    /*const*/HMapHeader/*&*/ Hdr = getHeader();
    /*uint*/int NumBuckets = getEndianAdjustedWord(Hdr.NumBuckets);
    
    // Don't probe infinitely.  This should be checked before constructing.
    assert (llvm.isPowerOf2_32(NumBuckets)) : "Expected power of 2";
    
    // Linearly probe the hash table.
    for (/*uint*/int Bucket = HashHMapKey(/*NO_COPY*/Filename);; ++Bucket) {
      HMapBucket B = getBucket(Bucket & (NumBuckets - 1));
      if (B.Key == HMAP_EmptyBucketKey) {
        return new StringRef(); // Hash miss.
      }
      
      // See if the key matches.  If not, probe on.
      Optional<StringRef> Key = getString(B.Key);
      if ((__builtin_expect((((boolean)(!Key.$bool())) ? 1 : 0), /*false*/0) != 0)) {
        continue;
      }
      if (!Filename.equals_lower(/*NO_COPY*/Key.$star())) {
        continue;
      }
      
      // If so, we have a match in the hash table.  Construct the destination
      // path.
      Optional<StringRef> Prefix = getString(B.Prefix);
      Optional<StringRef> Suffix = getString(B.Suffix);
      
      DestPath.clear();
      if ((__builtin_expect((((boolean)(Prefix.$bool() && Suffix.$bool())) ? 1 : 0), /*true*/1) != 0)) {
        // JAVA: use optimized version
        DestPath.append(Prefix.$star());
        DestPath.append(Suffix.$star());
      }
      return new StringRef(DestPath.begin(), DestPath.size());
    }
  }

  
  /// Return the filename of the headermap.
  
  //===----------------------------------------------------------------------===//
  //  Utility Methods
  //===----------------------------------------------------------------------===//
  
  /// getFileName - Return the filename of the headermap.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderMapImpl::getFileName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp", line = 109,
   FQN="clang::HeaderMapImpl::getFileName", NM="_ZNK5clang13HeaderMapImpl11getFileNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -nm=_ZNK5clang13HeaderMapImpl11getFileNameEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getFileName() /*const*/ {
    return FileBuffer.$arrow().getBufferIdentifier();
  }


  /// Print the contents of this headermap to stderr.
  
  //===----------------------------------------------------------------------===//
  // The Main Drivers
  //===----------------------------------------------------------------------===//
  @FunctionalInterface
  private interface StringID2StringRef {
    StringRef $call(/*uint*/int strID);
  }
  /// dump - Print the contents of this headermap to stderr.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderMapImpl::dump">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp", line = 172,
   FQN="clang::HeaderMapImpl::dump", NM="_ZNK5clang13HeaderMapImpl4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -nm=_ZNK5clang13HeaderMapImpl4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    /*const*/HMapHeader/*&*/ Hdr = getHeader();
    /*uint*/int NumBuckets = getEndianAdjustedWord(Hdr.NumBuckets);
    
    llvm.dbgs().$out(/*KEEP_STR*/"Header Map ").$out(getFileName()).$out(/*KEEP_STR*/":\n  ").$out_uint(NumBuckets).$out(/*KEEP_STR*/$COMMA_SPACE).$out_uint(getEndianAdjustedWord(Hdr.NumEntries)).$out(/*KEEP_STR*/$LF);
    
    StringID2StringRef getStringOrInvalid = (Id) -> 
    {
      {
        Optional<StringRef> S = getString(Id);
        if (S.$bool()) {
          return S.$star();
        }
      }
      return StringRef.R$invalid_marker;
    };
    
    for (/*uint*/int i = 0; i != NumBuckets; ++i) {
      HMapBucket B = getBucket(i);
      if (B.Key == HMAP_EmptyBucketKey) {
        continue;
      }
      
      StringRef Key = getStringOrInvalid.$call(B.Key);
      StringRef Prefix = getStringOrInvalid.$call(B.Prefix);
      StringRef Suffix = getStringOrInvalid.$call(B.Suffix);
      llvm.dbgs().$out(/*KEEP_STR*/"  ").$out_uint(i).$out(/*KEEP_STR*/". ").$out(/*NO_COPY*/Key).$out(/*KEEP_STR*/" -> '").$out(/*NO_COPY*/Prefix).$out(/*KEEP_STR*/"' '").$out(/*NO_COPY*/Suffix).$out(/*KEEP_STR*/"'\n");
    }
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderMapImpl::getEndianAdjustedWord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp", line = 113,
   FQN="clang::HeaderMapImpl::getEndianAdjustedWord", NM="_ZNK5clang13HeaderMapImpl21getEndianAdjustedWordEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -nm=_ZNK5clang13HeaderMapImpl21getEndianAdjustedWordEj")
  //</editor-fold>
  private /*uint*/int getEndianAdjustedWord(/*uint*/int X) /*const*/ {
    if (!NeedsBSwap) {
      return X;
    }
    return llvm.ByteSwap_32(X);
  }
  
  
  /// getHeader - Return a reference to the file header, in unbyte-swapped form.
  /// This method cannot fail.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderMapImpl::getHeader">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp", line = 120,
   FQN="clang::HeaderMapImpl::getHeader", NM="_ZNK5clang13HeaderMapImpl9getHeaderEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -nm=_ZNK5clang13HeaderMapImpl9getHeaderEv")
  //</editor-fold>
  private /*const*/HMapHeader/*&*/ getHeader() /*const*/ {
    // We know the file is at least as big as the header.  Return it.
    if (false) return $Deref(reinterpret_cast(/*const*/ HMapHeader /*P*/ .class, FileBuffer.$arrow().getBufferStart()));
    return HMapHeader.reinterpret_cast(FileBuffer.$arrow().getBufferStart());
  }

  
  /// getBucket - Return the specified hash table bucket from the header map,
  /// bswap'ing its fields as appropriate.  If the bucket number is not valid,
  /// this return a bucket with an empty key (0).
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderMapImpl::getBucket">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp", line = 128,
   FQN="clang::HeaderMapImpl::getBucket", NM="_ZNK5clang13HeaderMapImpl9getBucketEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -nm=_ZNK5clang13HeaderMapImpl9getBucketEj")
  //</editor-fold>
  private HMapBucket getBucket(/*uint*/int BucketNo) /*const*/ {
    assert ($greatereq_uint(FileBuffer.$arrow().getBufferSize(), HMapHeader.$sizeof_HMapHeader() + HMapBucket.$sizeof_HMapBucket() * BucketNo)) : "Expected bucket to be in range";
    
    HMapBucket Result/*J*/= new HMapBucket();
    Result.Key = HMAP_EmptyBucketKey;
    /*const*/HMapBucket/*P*/ BucketPtr;
    // JAVA: we can not reinterpret_cast in Java
    if (false) {
      /*const*/ type$ptr<HMapBucket>/*P*/ BucketArray = reinterpret_ptr_cast(/*const*/HMapBucket/*P*/ .class, FileBuffer.$arrow().getBufferStart().$add(sizeof(HMapHeader.class)));
      /*const*/ type$ptr<HMapBucket> /*P*/ Bucket = BucketArray.$add(BucketNo);
      BucketPtr = Bucket.$star();
    } else {
      int sizeof$HMapHeader = HMapHeader.$sizeof_HMapHeader();
      int BucketNoOffset = sizeof$HMapHeader + BucketNo * HMapBucket.$sizeof_HMapBucket();
      BucketPtr = HMapBucket.reinterpret_cast(FileBuffer.$arrow().getBufferStart().$add(BucketNoOffset));
    }
    // Load the values, bswapping as needed.
    Result.Key = getEndianAdjustedWord(BucketPtr.Key);
    Result.Prefix = getEndianAdjustedWord(BucketPtr.Prefix);
    Result.Suffix = getEndianAdjustedWord(BucketPtr.Suffix);    
    return Result;
  }

  
  /// Look up the specified string in the string table.  If the string index is
  /// not valid, return None.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderMapImpl::getString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp", line = 148,
   FQN="clang::HeaderMapImpl::getString", NM="_ZNK5clang13HeaderMapImpl9getStringEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -nm=_ZNK5clang13HeaderMapImpl9getStringEj")
  //</editor-fold>
  private Optional<StringRef> getString(/*uint*/int StrTabIdx) /*const*/ {
    // Add the start of the string table to the idx.
    StrTabIdx += getEndianAdjustedWord(getHeader().StringsOffset);
    
    // Check for invalid index.
    if ($greatereq_uint(StrTabIdx, FileBuffer.$arrow().getBufferSize())) {
      return new Optional<StringRef>(None);
    }
    
    /*const*/char$ptr/*char P*/ Data = $tryClone(FileBuffer.$arrow().getBufferStart().$add(StrTabIdx));
    /*uint*/int MaxLen = FileBuffer.$arrow().getBufferSize() - StrTabIdx;
    /*uint*/int Len = strnlen(Data, MaxLen);
    
    // Check whether the buffer is null-terminated.
    if (Len == MaxLen && (Data.$at(Len - 1) != 0)) {
      return new Optional<StringRef>(None);
    }
    
    return new Optional<StringRef>(JD$T$RR.INSTANCE, new StringRef(Data, Len));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::HeaderMapImpl::~HeaderMapImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderMap.h", line = 31,
   FQN="clang::HeaderMapImpl::~HeaderMapImpl", NM="_ZN5clang13HeaderMapImplD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -nm=_ZN5clang13HeaderMapImplD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    FileBuffer.$destroy();
    //END JDestroy
  }

  
  public String toString() {
    return "" + "FileBuffer=" + FileBuffer // NOI18N
              + ", NeedsBSwap=" + NeedsBSwap; // NOI18N
  }
}
