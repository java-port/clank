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

package org.clang.frontend.impl;

import org.clang.lex.java.PTHManagerDriver;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.frontend.impl.*;
import static org.clang.lex.PTHLexer.DISK_TOKEN_SIZE;
import org.llvm.support.sys.*;
import org.llvm.support.endian.*;
import static org.llvm.support.llvm.support.endianness.*;
import static org.clang.frontend.impl.CacheTokensStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHWriter">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 182,
 FQN="(anonymous namespace)::PTHWriter", NM="_ZN12_GLOBAL__N_19PTHWriterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_19PTHWriterE")
//</editor-fold>
public class PTHWriter implements Destructors.ClassWithDestructor {
  /*typedef llvm::DenseMap<const IdentifierInfo *, uint32_t> IDMap*/
//  public final class IDMap extends DenseMapTypeInt</*const*/ IdentifierInfo /*P*/ /*,uint32_t*/>{ };
  /*typedef llvm::StringMap<OffsetOpt, llvm::BumpPtrAllocator> CachedStrsTy*/
//  public final class CachedStrsTy extends StringMap<OffsetOpt, BumpPtrAllocator>{ };
  
  private DenseMapTypeInt</*const*/ IdentifierInfo /*P*/ /*,uint32_t*/> IM;
  private raw_pwrite_stream /*&*/ Out;
  private Preprocessor /*&*/ PP;
  private /*uint32_t*/int idcount;
  private OnDiskChainedHashTableGenerator<Void/*unused*/, PTHEntryKeyVariant, PTHEntry> PM;
  private StringMap<OffsetOpt/*, BumpPtrAllocator*/> CachedStrs;
  private /*Offset*/int CurStrOffset;
  private std.vector<StringMapEntry<OffsetOpt> /*P*/ > StrEntries;
  private final boolean keepComments;
  private final boolean emitIncompleteTokenState;
  
  //// Get the persistent id for the given IdentifierInfo*.
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHWriter::ResolveID">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 248,
   FQN="(anonymous namespace)::PTHWriter::ResolveID", NM="_ZN12_GLOBAL__N_19PTHWriter9ResolveIDEPKN5clang14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_19PTHWriter9ResolveIDEPKN5clang14IdentifierInfoE")
  //</editor-fold>
  private /*uint32_t*/int ResolveID(/*const*/ IdentifierInfo /*P*/ II) {
    // Null IdentifierInfo's map to the persistent ID 0.
    if (!(II != null)) {
      return 0;
    }
    
    // JAVA PERF: find or construct and check if already initialized
    pairTypeInt<IdentifierInfo> Entry = IM.FindAndConstruct(II);
    if (Entry.second > 0) {
      return Entry.second; // We've already added 1.
    }
    
    Entry.second = ++idcount; // Pre-increment since '0' is reserved for NULL.
    return idcount;
  }

  
  /// Emit a token to the PTH file.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHWriter::EmitToken">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 261,
   FQN="(anonymous namespace)::PTHWriter::EmitToken", NM="_ZN12_GLOBAL__N_19PTHWriter9EmitTokenERKN5clang5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_19PTHWriter9EmitTokenERKN5clang5TokenE")
  //</editor-fold>
  private void EmitToken(/*const*/ Token /*&*/ T) {
    // Emit the token kind (only 8bits), flags (only 8bits), and length.
    // JAVA FIX: incomplete-token-flag is kept in FileOffset
    /*uint32_t*/int Word0 = ((/*uint32_t*/int)T.getKind()) | ((((/*uint32_t*/int)0xFF & T.getFlags())) << 8)
            | (((/*uint32_t*/int)T.getLength()) << 16);
    Emit32(Word0);
    // assert the same logic as reading data in PTHLexer.Lex
    assert ((short)(Word0 & 0xFF)) == T.getKind() : T + " vs " + ((short)(Word0 & 0xFF));
    assert ((int/*Token.TokenFlags*/)((Word0 >>> 8) & 0xFF)) == (T.getFlags() & ~Token.TokenFlags.Incomplete) : T + " vs " + ((Word0 >>> 8) & 0xFF);
    assert ((Word0 >>> 16) & 0xFFFF/*unsigned shift*/) == T.getLength() : T + " vs " + ((Word0 >>> 16) & 0xFFFF);
    
    if (!T.isLiteral()) {
      Emit32(ResolveID(T.getIdentifierInfo()));
    } else {
      // JAVA PERF: use raw data instead of iterator/char$ptr/StringRef/pair
      
      // We cache *un-cleaned* spellings. This gives us 100% fidelity with the
      // source code.
      // Get the string entry.
      byte[] $CharPtrData = T.$CharPtrData();
      int TokLen = T.getLength();        
      StringMapEntry<OffsetOpt> /*&*/ E;
      if ($CharPtrData != null) {
        E = CachedStrs.GetOrCreateValue($CharPtrData, T.$CharPtrDataIndex(), TokLen);        
      } else {
        char$ptr LData = T.getLiteralData();
        if (LData != null) {
          E = CachedStrs.GetOrCreateValue(LData, T.getLength());
        } else {          
          E = null; // JAVA: could be incomplete token
        }
      }
      assert E == null || E.second == null || E.second.hasOffset() : "must be absent or with offset " + E.second;
      // If this is a new string entry, bump the PTH offset.
      if (E != null && E.second == null) {
        E.second = new OffsetOpt();
        E.second.setOffset(CurStrOffset);
        StrEntries.push_back(/*AddrOf*/E);
        CurStrOffset += TokLen + 1;
      }
      
      // Emit the relative offset into the PTH file for the spelling string.
      Emit32(E == null ? 0/*no text*/ : E.second.getOffset());
    }
    
    // Emit the offset into the original source file of this token so that we
    // can reconstruct its SourceLocation.
    int FileOffset = PP.getSourceManager().getFileOffset(T.$getLocation());
    // keep Incomplete Flag 
    assert FileOffset >= 0;
    if (emitIncompleteTokenState && T.isIncomplete()) {
      FileOffset |= PTHLexer.INCOMPLETE_TOKEN_FLAG_BIT; // see PTHLexer.Lex
    }
    Emit32(FileOffset);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHWriter::Emit8">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 201,
   FQN="(anonymous namespace)::PTHWriter::Emit8", NM="_ZN12_GLOBAL__N_19PTHWriter5Emit8Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_19PTHWriter5Emit8Ej")
  //</editor-fold>
  private void Emit8(/*uint32_t*/int V) {
    //JAVA: using namespace llvm::support;
    new Writer(little, Out).write_uint8(V);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHWriter::Emit16">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 206,
   FQN="(anonymous namespace)::PTHWriter::Emit16", NM="_ZN12_GLOBAL__N_19PTHWriter6Emit16Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_19PTHWriter6Emit16Ej")
  //</editor-fold>
  private void Emit16(/*uint32_t*/int V) {
    //JAVA: using namespace llvm::support;
    new Writer(little, Out).write_uint16(V);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHWriter::Emit32">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 211,
   FQN="(anonymous namespace)::PTHWriter::Emit32", NM="_ZN12_GLOBAL__N_19PTHWriter6Emit32Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_19PTHWriter6Emit32Ej")
  //</editor-fold>
  private void Emit32(/*uint32_t*/int V) {
    //JAVA: using namespace llvm::support;
    new Writer(little, Out).write_uint32(V);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHWriter::EmitBuf">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 216,
   FQN="(anonymous namespace)::PTHWriter::EmitBuf", NM="_ZN12_GLOBAL__N_19PTHWriter7EmitBufEPKcj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_19PTHWriter7EmitBufEPKcj")
  //</editor-fold>
  private void EmitBuf(/*const*/char$ptr/*char P*/ Ptr, /*uint*/int NumBytes) {
    Out.write(Ptr, NumBytes);
  }
  private void EmitBuf(/*const*/byte[]/*char P*/ Ptr, /*uint*/int PtrIdx, /*uint*/int NumBytes) {
    Out.write(Ptr, PtrIdx, NumBytes);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHWriter::EmitString">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 220,
   FQN="(anonymous namespace)::PTHWriter::EmitString", NM="_ZN12_GLOBAL__N_19PTHWriter10EmitStringEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_19PTHWriter10EmitStringEN4llvm9StringRefE")
  //</editor-fold>
  private void EmitString(StringRef V) {
    //JAVA: using namespace llvm::support;
    new Writer(little, Out).write_uint16(V.size());
    EmitBuf(V.data(), V.size());
  }

  
  /// EmitIdentifierTable - Emits two tables to the PTH file.  The first is
  ///  a hashtable mapping from identifier strings to persistent IDs.
  ///  The second is a straight table mapping from persistent IDs to string data
  ///  (the keys of the first table).
  // end anonymous namespace
  
  /// EmitIdentifierTable - Emits two tables to the PTH file.  The first is
  ///  a hashtable mapping from identifier strings to persistent IDs.  The second
  ///  is a straight table mapping from persistent IDs to string data (the
  ///  keys of the first table).
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHWriter::EmitIdentifierTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 653,
   FQN="(anonymous namespace)::PTHWriter::EmitIdentifierTable", NM="_ZN12_GLOBAL__N_19PTHWriter19EmitIdentifierTableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_19PTHWriter19EmitIdentifierTableEv")
  //</editor-fold>
  private std.pairIntInt/*<Offset,Offset>*/ EmitIdentifierTable() {
    OnDiskChainedHashTableGenerator<Void/*unused*/, PTHIdKey, Integer> IIOffMap = null;
    try {
      // Build two maps:
      //  (1) an inverse map from persistent IDs -> (IdentifierInfo*,Offset)
      //  (2) a map from (IdentifierInfo*, Offset)* -> persistent IDs
      
      // Note that we use 'calloc', so all the bytes are 0.
//      PTHIdKey /*P*/ IIDMap = (PTHIdKey /*P*/ )calloc(idcount, sizeof(PTHIdKey));
      // JAVA: replace calloc by array and initialize elements
      PTHIdKey /*P*/ IIDMap[] = new PTHIdKey[idcount]; // JAVA
      for (int i = 0; i < idcount; i++) {
        IIDMap[i] = new PTHIdKey();
      }
      // Create the hashtable.
      IIOffMap/*J*/= new OnDiskChainedHashTableGenerator<Void/*unused*/, PTHIdKey, Integer>(new PTHIdentifierTableTrait());
      
      // Generate mapping from persistent IDs -> IdentifierInfo*.
      for (DenseMapIteratorTypeInt<IdentifierInfo> I = IM.begin(), E = IM.end(); I.$noteq(/*NO_ITER_COPY*/E); I.$preInc()) {
        // Decrement by 1 because we are using a vector for the lookup and
        // 0 is reserved for NULL.
        assert ($greater_uint(I.$arrow().second, 0));
        assert ($less_uint(I.$arrow().second - 1, idcount));
        /*uint*/int idx = I.$arrow().second - 1;
        
        // Store the mapping from persistent ID to IdentifierInfo*
        IIDMap[idx].II = I.$arrow().first;
        
        // Store the reverse mapping in a hashtable.
        IIOffMap.insert(/*AddrOf*/IIDMap[idx], I.$arrow().second);
      }
      
      // Write out the inverse map first.  This causes the PCIDKey entries to
      // record PTH file offsets for the string data.  This is used to write
      // the second table.
      /*Offset*/int StringTableOffset = IIOffMap.Emit(Out);
      
      // Now emit the table mapping from persistent IDs to PTH file offsets.
      /*Offset*/int IDOff = $long2uint(Out.tell());
      Emit32(idcount); // Emit the number of identifiers.
      for (/*uint*/int i = 0; i < idcount; ++i)  {
        Emit32(IIDMap[(int)i].FileOffset);
      }
      
      // Finally, release the inverse map.
      free(IIDMap);
      
      return std.make_pair_int_int(IDOff, StringTableOffset);
    } finally {
      if (IIOffMap != null) { IIOffMap.$destroy(); }
    }
  }

  
  /// EmitFileTable - Emit a table mapping from file name strings to PTH
  /// token data.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHWriter::EmitFileTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 234,
   FQN="(anonymous namespace)::PTHWriter::EmitFileTable", NM="_ZN12_GLOBAL__N_19PTHWriter13EmitFileTableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_19PTHWriter13EmitFileTableEv")
  //</editor-fold>
  private /*Offset*/int EmitFileTable() {
    return PM.Emit(Out);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHWriter::LexTokens">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 292,
   FQN="(anonymous namespace)::PTHWriter::LexTokens", NM="_ZN12_GLOBAL__N_19PTHWriter9LexTokensERN5clang5LexerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_19PTHWriter9LexTokensERN5clang5LexerE")
  //</editor-fold>
  private PTHEntry LexTokens(Lexer /*&*/ L) {
    // JAVA FIX: we need more tokens than native variant
    assert true : "This method was changed to have EOD tokens emitted with correct offsets";
    std.vector<std.pairIntInt/*Offset,uint*/> PPCond = null;
    std.vectorInt/*uint*/ PPStartCond = null;
    try {
      // Pad 0's so that we emit tokens to a 4-byte alignment.
      // This speed up reading them back in.
      //JAVA: using namespace llvm::support;
      Writer LE/*J*/= new Writer(little, Out);
      /*uint32_t*/int TokenOff = $long2uint(Out.tell());
      for (long/*uint64_t*/ N = llvm.OffsetToAlignment(TokenOff, 4); (N != 0); --N , ++TokenOff)  {
        LE.write_uint8(0);
      }
      
      // Keep track of matching '#if' ... '#endif'.
      /*typedef std::vector<std::pair<Offset, unsigned int> > PPCondTable*/
//      final class PPCondTable extends std.vector<std.pairIntInt/*Offset,uint*/>{ };
      PPCond/*J*/= new std.vector<std.pairIntInt/*Offset,uint*/>(new std.pairIntInt/*Offset,uint*/(0,0));
      PPStartCond/*J*/= new std.vectorInt/*uint*/();
      Token Tok/*J*/= new Token();
      
      do {
        L.LexFromRawLexer(Tok);
    // NextToken: label is not needed in JAVA version where we emit more tokens
    
        // JAVA: special handling for raw_identifiers (to init IdentifierInfo)
        // and leading # which starts pp-directives
        if (Tok.is(tok.TokenKind.raw_identifier)) {
          PP.LookUpIdentifierInfo(Tok);          
          // JAVA FIX: PP.LookUpIdentifierInfo(Tok) can change token kind
          // switch back token kind to identifier, 
          // otherwise it will be stored i.e. as keyword
          // but presentation must be language neutral
          Tok.setKind(tok.TokenKind.identifier);
        } else if (Tok.is(tok.TokenKind.hash) && Tok.isAtStartOfLine()) {
          // JAVA: this is the start of PP-directive
          
          // Special processing for #include.  Store the '#' token and lex
          // the next token.
          assert (!L.isParsingPreprocessorDirective());
          
          // JAVA: remember stream position where this pp-directive start token is stored
          /*Offset*/int HashOff = (/*Offset*/int)$long2uint(Out.tell());

          // The token is the start of a directive.  Emit it.
          EmitToken(Tok);
          
          // JAVA: switch to parsing PP-directive mode to have eod tokens
          L.setParsingPreprocessorDirective(true);
          
          // Get the next token.
          L.LexFromRawLexer(Tok);
          while (Tok.is(tok.TokenKind.comment)) {
            EmitToken(Tok);
            L.LexFromRawLexer(Tok);
          }

          // If we see the start of line, then we had a null directive "#".  In
          // this case, discard both tokens.
          assert !(Tok.isAtStartOfLine()) : "JAVA: Couldn't be in Parsing PP mode, at least eod must be met: " + Tok;
          
          // Did we see PP-keyword 'include'/'import'/'include_next'/...?
          if (Tok.is(tok.TokenKind.raw_identifier)) {

            IdentifierInfo /*P*/ II = PP.LookUpIdentifierInfo(Tok);
            /*tok.PPKeywordKind*/char K = II.getPPKeywordID();

            switch (K) {
             case tok.PPKeywordKind.pp_not_keyword:
             default:
              // Invalid directives "#foo" can occur in #if 0 blocks etc, just pass
              // them through.

              // JAVA FIX: PP.LookUpIdentifierInfo(Tok) can change token kind
              // switch back token kind to identifier, 
              // otherwise it will be stored i.e. as keyword
              // but presentation must be language neutral
              Tok.setKind(tok.TokenKind.identifier);
              break;
             case tok.PPKeywordKind.pp_include:
             case tok.PPKeywordKind.pp_import:
             case tok.PPKeywordKind.pp_include_next:
              {
                // Save the 'include' token.
                EmitToken(Tok);
                // Lex the next token as an include string.
                L.LexIncludeFilename(Tok);
                assert (!Tok.isAtStartOfLine());

                // handle #include /*comment*/<file> correctly
                while (Tok.is(tok.TokenKind.comment)) {
                  EmitToken(Tok);
                  L.LexIncludeFilename(Tok);
                  assert (!Tok.isAtStartOfLine());
                }
                
                if (Tok.is(tok.TokenKind.raw_identifier)) {
                  PP.LookUpIdentifierInfo(Tok);
                  // JAVA FIX: PP.LookUpIdentifierInfo(Tok) can change token kind
                  // switch back token kind to identifier, 
                  // otherwise it will be stored i.e. as keyword
                  // but presentation must be language neutral
                  Tok.setKind(tok.TokenKind.identifier);
                }

                break;
              }
             case tok.PPKeywordKind.pp_if:
             case tok.PPKeywordKind.pp_ifdef:
             case tok.PPKeywordKind.pp_ifndef:
              {
                // Add an entry for '#if' and friends.  We initially set the target
                // index to 0.  This will get backpatched when we hit #endif.
                PPStartCond.push_back(PPCond.size());
                PPCond.push_back(std.make_pair_int_int(HashOff, 0/*U*/));
                break;
              }
             case tok.PPKeywordKind.pp_endif:
              {
                
                // JAVA FIX: handle unbalanced #endif entry without assert
                // JAVA: commented out assert (!PPStartCond.empty());
                if (!PPStartCond.empty()) {
                  // Add an entry for '#endif'.  We set the target table index to itself.
                  // This will later be set to zero when emitting to the PTH file.  We
                  // use 0 for uninitialized indices because that is easier to debug.
                  /*uint*/int index = PPCond.size();
                  finishEndif(index, PPCond, PPStartCond, HashOff);
                } else {
                  Diag(Tok, "Error: imbalanced #endif preprocessor conditionals.");
                }               
                if (keepComments) {
                  // when PTH was created in keepComments mode
                  // leave any extra tokens to be able to produce diagnostics
                } else {
                  // emit endif
                  EmitToken(Tok);
                  // Native PTH reader expects that #endif is followed by EOD
                  // eat all extra text
                  // #endif M //comment
                  do {
                    L.LexFromRawLexer(Tok);
                    // skip EmitToken(Tok);
                  } while (Tok.isNot(tok.TokenKind.eod));
                }
                break;
              }
             case tok.PPKeywordKind.pp_elif:
             case tok.PPKeywordKind.pp_else:
              {
                // JAVA FIX: handle unbalanced #else/#elif entry without assert
                if (!PPStartCond.empty()) {
                  // Add an entry for #elif or #else.
                  // This serves as both a closing and opening of a conditional block.
                  // This means that its entry will get backpatched later.
                  /*uint*/int index = PPCond.size();
                  // Backpatch the previous '#if' entry.

                  // JAVA: error recovery for #else/#elif at the start of file
                  // JAVA: commented out assert (!PPStartCond.empty());

                  assert (PPCond.size() > PPStartCond.back());
                  assert (PPCond.$at(PPStartCond.back()).second == 0);
                  // JAVA: close the balanced by setting index of to-be-added #
                  PPCond.$at(PPStartCond.back()).second = index;
                  PPStartCond.pop_back();
                  // Now add '#elif'/'#else' as a new block opening.
                  PPCond.push_back(std.make_pair_int_int(HashOff, 0/*U*/));
                  PPStartCond.push_back(index);
                } else {
                  // JAVA: do not crash, only report an error
                  Diag(Tok, "Error: imbalanced #else/#elif preprocessor conditionals ");
                }
                break;
              }
            }
          }
        }
        assert Tok.isNot(tok.TokenKind.eod) || !L.isParsingPreprocessorDirective() : 
                "must be false after producing EOD " + Tok + " vs. " + L.isParsingPreprocessorDirective();
        EmitToken(Tok);
      } while (Tok.isNot(tok.TokenKind.eof));
      
      // Next write out PPCond.
      /*Offset*/int PPCondOff = (/*Offset*/int)$long2uint(Out.tell());
      
      assert Tok.is(tok.TokenKind.eof) : "it must be end of file";
      // JAVA FIX: recover unbalanced conditions (no enclosing #endif) without assert
      // assert (PPStartCond.empty()) : "Error: imblanced preprocessor conditionals.";
      if (!PPStartCond.empty() && emitIncompleteTokenState) {
        // let's use EOF token as closing #endif for all unbalanced branches
        int EofAsFakeHashOffsetInStream = PPCondOff - DISK_TOKEN_SIZE;
        // Close each entry with own fake '#endif'. 
        /*uint*/int fakeEndifIndex = PPCond.size();
        while (!PPStartCond.empty()) {
          finishEndif(fakeEndifIndex, PPCond, PPStartCond, EofAsFakeHashOffsetInStream);
          fakeEndifIndex++;
        }
      }
      
      // Write out the size of PPCond so that clients can identifer empty tables.
      Emit32(PPCond.size());
      
      for (/*uint*/int i = 0, e = PPCond.size(); i != e; ++i) {        
        Emit32(PPCond.$at(i).first - TokenOff);
        /*uint32_t*/int x = PPCond.$at(i).second;
        assert (x != 0) : "PPCond entry not backpatched.";
        // Emit zero for #endifs.  This allows us to do checking when
        // we read the PTH file back in.
        Emit32(x == i ? 0 : x);
      }
      
      return new PTHEntry(TokenOff, PPCondOff);
    } finally {
      if (PPStartCond != null) { PPStartCond.$destroy(); }
      if (PPCond != null) { PPCond.$destroy(); }
    }
  }

  private void finishEndif(int index, vector<pairIntInt> PPCond, vectorInt PPStartCond, int HashOff) {
    assert !PPCond.empty() : "must be called only when has block to complete";
    // Backpatch the opening '#if'/'elif'/'else' entry.
    
    assert (PPCond.size() > PPStartCond.back());
    assert (PPCond.$at(PPStartCond.back()).second == 0);
    PPCond.$at(PPStartCond.back()).second = index;
    PPStartCond.pop_back();
    // Add the new entry to PPCond.
    PPCond.push_back(std.make_pair_int_int(HashOff, index));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHWriter::EmitCachedSpellings">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 461,
   FQN="(anonymous namespace)::PTHWriter::EmitCachedSpellings", NM="_ZN12_GLOBAL__N_19PTHWriter19EmitCachedSpellingsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_19PTHWriter19EmitCachedSpellingsEv")
  //</editor-fold>
  private /*Offset*/int EmitCachedSpellings() {
    // Write each cached strings to the PTH file.
    /*Offset*/int SpellingsOff = $long2uint(Out.tell());
    
    for (int i = 0; i < StrEntries.size(); i++) {
      StringMapEntry<OffsetOpt> Str = StrEntries.$at(i);
      EmitBuf(Str.getKeyArray(), Str.getKeyArrayIndex(), Str.getKeyLength() + 1/*nul included*/);
    }
    
    return SpellingsOff;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHWriter::PTHWriter">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*ctr for raw_pwrite_stream*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 240,
   FQN="(anonymous namespace)::PTHWriter::PTHWriter", NM="_ZN12_GLOBAL__N_19PTHWriterC1ERN4llvm17raw_pwrite_streamERN5clang12PreprocessorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_19PTHWriterC1ERN4llvm17raw_pwrite_streamERN5clang12PreprocessorE")
  //</editor-fold>
  public PTHWriter(raw_pwrite_stream /*&*/ out, Preprocessor /*&*/ pp) {
    this(out, pp, PTHManagerDriver.KEEP_PTH_COMMENTS, PTHManagerDriver.KEEP_INCOMPLETE_TOKEN_STATE);
  }
  public PTHWriter(raw_pwrite_stream /*&*/ out, Preprocessor /*&*/ pp, boolean needComments, boolean emitIncompleteTokenState) {
    /* : IM(), Out(out), PP(pp), idcount(0), PM(), CachedStrs(), CurStrOffset(0), StrEntries()*/ 
    //START JInit
    this.IM = new DenseMapTypeInt</*const*/ IdentifierInfo /*P*/ /*,uint32_t*/>(IdentifierInfo.DMI$IdentifierInfoPtr, 0);
    this.Out = out;
    this.PP = pp;
    this.idcount = 0;
    this.PM = new OnDiskChainedHashTableGenerator<Void/*unused*/, PTHEntryKeyVariant, PTHEntry>(new FileEntryPTHEntryInfo());
    this.CachedStrs = new StringMap<OffsetOpt/*, BumpPtrAllocator*/>(new BumpPtrAllocator(), null/*PERF: new OffsetOpt()*/);
    this.CurStrOffset = 0;
    this.StrEntries = new std.vector<StringMapEntry<OffsetOpt> /*P*/ >(0, (StringMapEntry<OffsetOpt> /*P*/)null);
    //END JInit
    this.keepComments = needComments;
    this.emitIncompleteTokenState = emitIncompleteTokenState;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHWriter::getPM">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 243,
   FQN="(anonymous namespace)::PTHWriter::getPM", NM="_ZN12_GLOBAL__N_19PTHWriter5getPMEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_19PTHWriter5getPMEv")
  //</editor-fold>
  public OnDiskChainedHashTableGenerator<Void/*unused*/, PTHEntryKeyVariant, PTHEntry>/*&*/ getPM() {
    return PM;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHWriter::GeneratePTH">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 482,
   FQN="(anonymous namespace)::PTHWriter::GeneratePTH", NM="_ZN12_GLOBAL__N_19PTHWriter11GeneratePTHEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_19PTHWriter11GeneratePTHEN4llvm9StringRefE")
  //</editor-fold>
  public void GeneratePTH(StringRef MainFile) {
    GeneratePTH(MainFile.str());
  }
  public void GeneratePTH(/*const*/std.string/*&*/ MainFile) {
    GeneratePTH(MainFile, FileID.getInvalidID());
  }
  // JAVA: introduced new method to allow caching only one FileEntry
  public void GeneratePTH(/*const*/std.string/*&*/ MainFile, /*FileID*/int CachedFID) {
    // Generate the prologue.
    Out.$out(/*KEEP_STR*/$cfe_pth).$out_char($$TERM);
    Emit32(PTHManager.Unnamed_enum.Version);
    
    // Leave 4 words for the prologue.
    /*Offset*/int PrologueOffset = $long2uint(Out.tell());
    for (/*uint*/int i = 0; i < 4; ++i)  {
      Emit32(0);
    }
    
    // Write the name of the MainFile.
    if (!MainFile.empty()) {
      EmitString(new StringRef(MainFile));
    } else {
      // String with 0 bytes.
      Emit16(0);
    }
    Emit8(0);
    
    // Iterate over all the files in SourceManager.  Create a lexer
    // for each file and cache the tokens.
    SourceManager /*&*/ SM = PP.getSourceManager();
    // JAVA FIX: need to use language neutral options, not the current PP options
    // i.e. to support dead code branches targeting C++ when the current PP is for C
    /*const*/ LangOptions /*&*/ LOpts;
    if (true) {
      LOpts = $LangOptions();
    } else {
      LOpts = PP.getLangOpts();
    }
    if (CachedFID != FileID.getInvalidID()) {
      FileEntry CacheOnlyOneFE = SM.getFileEntryForID(CachedFID);
      /*const*/ MemoryBuffer /*P*/ FromFile = SM.getBuffer(CachedFID);
      Lexer L = null;   
      try {
        L = L/*J*/= new Lexer(CachedFID, FromFile, SM, LOpts);
        L.SetCommentRetentionState(keepComments);
        PM.insert(new PTHEntryKeyVariant(CacheOnlyOneFE), LexTokens(L));
      } finally {
        if (L != null) { L.$destroy(); }
      }
    } else {
      for (DenseMapIterator</*const*/ FileEntry /*P*/ , SrcMgr.ContentCache /*P*/ > I = SM.fileinfo_begin(), 
          E = SM.fileinfo_end(); I.$noteq(E); I.$preInc()) {
        Lexer L = null;
        try {
          /*const*/ SrcMgr.ContentCache /*&*/ C = /*Deref*/I.$arrow().second;
          /*const*/ FileEntry /*P*/ FE = C.OrigEntry;

          // FIXME: Handle files with non-absolute paths.
          if (path.is_relative(new Twine(FE.getName()))) {
            continue;
          }

          /*const*/ MemoryBuffer /*P*/ B = C.getBuffer(PP.getDiagnostics(), SM);
          if (!(B != null)) {
            continue;
          }

          /*FileID*/int FID = SM.createFileID(FE, SourceLocation.getInvalid(), SrcMgr.CharacteristicKind.C_User);
          /*const*/ MemoryBuffer /*P*/ FromFile = SM.getBuffer(FID);
          L/*J*/= new Lexer(FID, FromFile, SM, LOpts);
          // JAVA FIX: keep comments
          L.SetCommentRetentionState(keepComments);
          PM.insert(new PTHEntryKeyVariant(FE), LexTokens(L));
        } finally {
          if (L != null) { L.$destroy(); }
        }
      }
    }
    
    // Write out the identifier table.
    /*const*/std.pairIntInt/*<Offset,Offset>*//*&*/ IdTableOff = EmitIdentifierTable();
    
    // Write out the cached strings table.
    /*Offset*/int SpellingOff = EmitCachedSpellings();
    
    // Write out the file table.
    /*Offset*/int FileTableOff = EmitFileTable();
    
    // Finally, write the prologue.
    if (false && (Out instanceof raw_fd_ostream)) {
      // 3.6 version
      ((raw_fd_ostream)Out).seek(PrologueOffset);
      Emit32(IdTableOff.first);
      Emit32(IdTableOff.second);
      Emit32(FileTableOff);
      Emit32(SpellingOff);
    } else {
      // 3.9 version
      ulong$ref/*uint64_t*/ Off = create_ulong$ref($int2ulong(PrologueOffset));
      pwrite32le(Out, IdTableOff.first, Off);
      pwrite32le(Out, IdTableOff.second, Off);
      pwrite32le(Out, FileTableOff, Off);
      pwrite32le(Out, SpellingOff, Off);      
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHWriter::~PTHWriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 182,
   FQN="(anonymous namespace)::PTHWriter::~PTHWriter", NM="_ZN12_GLOBAL__N_19PTHWriterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_19PTHWriterD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    StrEntries.$destroy();
    CachedStrs.$destroy();
    PM.$destroy();
    IM.$destroy();
    //END JDestroy
  }

  
  public String toString() {
    return "" + "IM=" + IM.size() // NOI18N
              + ", Out=" + Out // NOI18N
              /* STACKOVERFLOW: NEVER PRINT Preprocessor + ", PP=" + PP // NOI18N */
              + ", idcount=" + idcount // NOI18N
              + ", PM=" + PM // NOI18N
              + ", CachedStrs=" + CachedStrs.size() // NOI18N
              + ", CurStrOffset=" + CurStrOffset // NOI18N
              + ", StrEntries=" + StrEntries.size(); // NOI18N
  }

  // JAVA: we need options which can be later used by all languages 
  private LangOptions $LangOptions() {
    LangOptions Opts = new LangOptions();
    // use the biggest union
    Opts.C11 = true;
    Opts.CPlusPlus   = true;
    Opts.CPlusPlus11 = true;
    Opts.CPlusPlus14 = true;
    Opts.CPlusPlus1z = true;
    Opts.Digraphs = true;
    Opts.Trigraphs = true;
    Opts.LineComment = true;
    return Opts;
  }

  private void Diag(Token Tok, String msg) {
    if (!NativeTrace.USE_PTH_DRIVER_IN_TEST) {
      $out_DiagnosticBuilder$C_StringRef(PP.getDiagnostics().Report(Tok.$getLocation(), diag.err_invalid_pth_file), StringRef.R$EMPTY).$destroy();
    }
  }
}
