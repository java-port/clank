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

package org.clang.lex.java.impl;

import org.clang.lex.PTHManager;
import org.clank.java.std;
import static org.clank.java.std_pair.*;
import org.clank.support.Native;
import static org.clank.support.Native.*;
import org.clank.support.NativePointer;
import org.clank.support.aliases.*;
import static org.clank.support.NativeType.*;
import org.clank.support.aliases.char$ptr;
import org.llvm.support.OnDiskChainedHashTable;
import org.llvm.support.llvm;
import static org.llvm.support.llvm.support.aligned;
import static org.llvm.support.llvm.support.endianness.little;
import static org.llvm.support.llvm.support.unaligned;

/**
 * PERF: specialaztion for optimizing performance
 * @author Vladimir Voskresensky
 */
public final class PTHStringIdLookup extends OnDiskChainedHashTable</*const*/ std.pairTypeInt</*const*/ char$ptr/*char P*/>, /*const*/ std.pairTypeInt</*const*/ char$ptr/*char P*/>, Number> {
  private PTHStringIdLookup(int NumBuckets, int NumEntries, char$ptr Buckets, char$ptr Base,
          PTHManager.PTHStringLookupTrait Info) {
    super(NumBuckets, NumEntries, Buckets, Base, Info);
  }
  
  public static PTHStringIdLookup CreatePTHStringIdLookup(/*const*/char$ptr/*uchar P*/ Buckets, 
        /*const*/char$ptr/*uchar P*//*const*/ Base,
        PTHManager.PTHStringLookupTrait Info) {
    //JAVA: using namespace llvm::support;
    assert (Buckets.$greater(Base)) : Buckets.$index() + " vs. " + Base.$index() + ":" + Base;
    assert ((Buckets.$index() & 0x3) == 0) : "buckets should be 4-byte aligned. " + Buckets.$index();
    
    /*uint*/int NumBuckets = llvm.support.endian.readNext_uint32(little, aligned, Buckets);
    /*uint*/int NumEntries = llvm.support.endian.readNext_uint32(little, aligned, Buckets);
    return new PTHStringIdLookup(NumBuckets, NumEntries, $noClone(Buckets), $noClone(Base), Info);
  }

  public Number get(char$ptr Name, int NameLen) {
    // PERF: do fast check first to see if info is potentially presented
    
    /*uint32_t*/int KeyHash = llvm.HashString(Name, NameLen);
    /*uint*/int Offset = getOffsetImpl(KeyHash);
    if (Offset == 0) {
      return null; // Empty bucket.
    }    
    std.pairTypeInt<char$ptr> IKey = $getIKey(Name, NameLen);
    Number out = getImpl(IKey, KeyHash, Offset);
    $releaseIKey(IKey);
    return out;
  }
  public Number get(byte[] Name, int NameStIndex, int NameLen) {
    // PERF: do fast check first to see if info is potentially presented
    
    /*uint32_t*/int KeyHash = llvm.HashString(Name, NameStIndex, NameLen);
    int Offset = getOffsetImpl(KeyHash);
    if (Offset == 0) {
      return null; // Empty bucket.
    }    
    std.pairTypeInt<char$ptr> IKey = $getIKey(Name, NameStIndex, NameLen);
    Number out = getImpl(IKey, KeyHash, Offset);
    $releaseIKey(IKey);
    return out;
  }
  
  private int getOffsetImpl(/*uint32_t*/int KeyHash) {
    // Each bucket is just an offset into the hash table file.
    /*uint*/int Idx = KeyHash & (NumBuckets - 1);
    assert Idx >= 0 : "negative " + Idx + " for " + KeyHash + " with " + NumBuckets;
    /*const*/int/*uchar P*/ Bucket = /*Buckets.$add*/(sizeof$uint32() * Idx);
    
    /*uint*/int Offset = llvm.support.endian.read_uint32(little, aligned, Buckets, Bucket);
                                        // PERF: Bucket += sizeof$uint32(); // shift index
    return Offset;
  }  
  
  private Number getImpl(/*const*//*const*/std.pairTypeInt</*const*/char$ptr/*char P*/>/*&*/ /*&*/ IKey,
          /*uint32_t*/int KeyHash, int Offset) {
    //JAVA: using namespace llvm::support;
      
    assert Offset > 0;
    PTHManager.PTHStringLookupTrait InfoPtr = (PTHManager.PTHStringLookupTrait) super.InfoObj;
    /*const*/int/*uchar P*/ Items = /*Base.$add*/(Offset);
    
    // 'Items' starts with a 16-bit unsigned integer representing the
    // number of items in this bucket.
    /*uint*/int Len = llvm.support.endian.read_uint16(little, unaligned, Base, Items);
                                          Items += sizeof$uint16(); // shift index
    for (/*uint*/int i = 0; i < Len; ++i) {
      // Read the hash.
      /*uint32_t*/int ItemHash = llvm.support.endian.read_uint32(little, unaligned, Base, Items);
                                          Items += sizeof$uint32(); // shift index
      // Determine the length of the key and the data.
      /*const*//*std.pair<uint, uint>*/long/*&*/ L = InfoPtr.ReadKeyDataLength(Base, Items);
      Items+=/*.$inc*/InfoPtr.getReadKeyDataLengthBytes();
      int KeyLen = $first_int(L);
      int DataLen = $second_int(L);
      /*uint*/int ItemLen = KeyLen + DataLen;
      
      // Compare the hashes.  If they are not the same, skip the entry entirely.
      if (ItemHash != KeyHash) {
        Items+=/*.$inc*/(ItemLen);
        continue;
      }
      
      // Read the key.
      /*const*//*const*/std.pairTypeInt</*const*/char$ptr/*char P*/>/*&*/ /*&*/ X = InfoPtr.ReadKey(Base, Items, KeyLen);
      
      // If the key doesn't match just skip reading the value.
      if (!InfoPtr.EqualKey(X, IKey)) {
        Items+=/*.$inc*/(ItemLen);
        InfoPtr.$releaseKey(X);
        continue;
      }
      
      // The key matches!
      Number Out = InfoPtr.ReadData(X, Base, Items+=KeyLen, DataLen);
      InfoPtr.$releaseKey(X);
      return Out;
    }
    
    return null;
  }
  
  private boolean $IKeyInUse = false;
  private final std.pairTypeInt</*const*/char$ptr/*char P*/> $IKey = new std.pairTypeInt</*const*/char$ptr/*char P*/>(null, 0);
  private final char$ptr$array $IKeyCharPtr = (char$ptr$array)NativePointer.create_reusable_char$ptr();
  private std.pairTypeInt</*const*/char$ptr/*char P*/> $getIKey(byte[] Name, int NameStIndex, int NameLen) {
    assert (!$IKeyInUse) && ($IKeyInUse = true);
    Native.$setArrayAndIndex($IKeyCharPtr, Name, NameStIndex);
    $IKey.first = $IKeyCharPtr;
    $IKey.second = NameLen;
    return $IKey;
  }
  private std.pairTypeInt</*const*/char$ptr/*char P*/> $getIKey(char$ptr Name, int NameLen) {
    assert (!$IKeyInUse) && ($IKeyInUse = true);
    $IKey.first = Name;
    $IKey.second = NameLen;
    return $IKey;
  }
  private void $releaseIKey(std.pairTypeInt</*const*/char$ptr/*char P*/> IKey) {
    assert IKey == $IKey;
    assert $IKeyInUse;
    assert ($IKeyInUse = false) || true;
    $IKey.first = null;
  }
}
