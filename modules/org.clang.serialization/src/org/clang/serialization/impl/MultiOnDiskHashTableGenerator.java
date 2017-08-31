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

package org.clang.serialization.impl;

import org.clank.java.std;
import org.clank.support.*;
import org.llvm.adt.*;
import org.llvm.support.*;
import org.llvm.support.endian.Writer;
import org.llvm.support.llvm.support.endian;
import static org.llvm.support.llvm.support.endianness.little;


/// \brief Writer for the on-disk hash table.
/*template <typename ReaderInfo, typename WriterInfo> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::serialization::MultiOnDiskHashTableGenerator">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/MultiOnDiskHashTable.h", line = 275,
 FQN="clang::serialization::MultiOnDiskHashTableGenerator", NM="_ZN5clang13serialization29MultiOnDiskHashTableGeneratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/Module.cpp -nm=_ZN5clang13serialization29MultiOnDiskHashTableGeneratorE")
//</editor-fold>
public class MultiOnDiskHashTableGenerator<reader_external_key_type, reader_data_type, file_type, internal_key_type, writer_data_type>  implements Destructors.ClassWithDestructor {
  // JAVA: typedef MultiOnDiskHashTable<ReaderInfo> BaseTable
//  public final class BaseTable extends MultiOnDiskHashTable<ReaderInfo>{ };
  // JAVA: typedef llvm::OnDiskChainedHashTableGenerator<WriterInfo> Generator
//  public final class Generator extends OnDiskChainedHashTableGenerator<WriterInfo>{ };
  
  private final OnDiskChainedHashTableGenerator<?/*unused*/, internal_key_type, writer_data_type> Gen;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::MultiOnDiskHashTableGenerator::MultiOnDiskHashTableGenerator<ReaderInfo, WriterInfo>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/MultiOnDiskHashTable.h", line = 283,
   FQN="clang::serialization::MultiOnDiskHashTableGenerator::MultiOnDiskHashTableGenerator<ReaderInfo, WriterInfo>", NM="_ZN5clang13serialization29MultiOnDiskHashTableGeneratorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/Module.cpp -nm=_ZN5clang13serialization29MultiOnDiskHashTableGeneratorC1Ev")
  //</editor-fold>
  public MultiOnDiskHashTableGenerator(OnDiskChainedHashTableGenerator.EmitInfoInterface<internal_key_type, writer_data_type, file_type> WriterInfo) {
    // : Gen() 
    //START JInit
    this.Gen = /*ParenListExpr*/new OnDiskChainedHashTableGenerator<Void/*unused*/, internal_key_type, writer_data_type>(WriterInfo);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::MultiOnDiskHashTableGenerator::insert">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/MultiOnDiskHashTable.h", line = 285,
   FQN="clang::serialization::MultiOnDiskHashTableGenerator::insert", NM="_ZN5clang13serialization29MultiOnDiskHashTableGenerator6insertENT0_12key_type_refENS2_13data_type_refERS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/Module.cpp -nm=_ZN5clang13serialization29MultiOnDiskHashTableGenerator6insertENT0_12key_type_refENS2_13data_type_refERS2_")
  //</editor-fold>
  public void insert( /*WriterInfo.key_type_ref*/internal_key_type /*&*/ Key, 
         /*WriterInfo.data_type_ref*/writer_data_type /*&*/ Data, final OnDiskChainedHashTableGenerator.EmitInfoInterface<internal_key_type, writer_data_type, file_type> /*&*/ Info) {
    Gen.insert(Key, Data, Info);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::MultiOnDiskHashTableGenerator::emit">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/MultiOnDiskHashTable.h", line = 290,
   FQN="clang::serialization::MultiOnDiskHashTableGenerator::emit", NM="_ZN5clang13serialization29MultiOnDiskHashTableGenerator4emitERN4llvm15SmallVectorImplIcEERT0_PKNS0_20MultiOnDiskHashTableIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/Module.cpp -nm=_ZN5clang13serialization29MultiOnDiskHashTableGenerator4emitERN4llvm15SmallVectorImplIcEERT0_PKNS0_20MultiOnDiskHashTableIT_EE")
  //</editor-fold>
  public void emit(final SmallString/*&*/ Out, final MultiEmitInfoInterface<internal_key_type, writer_data_type, reader_data_type, file_type> /*&*/ Info, 
      /*const*/ MultiOnDiskHashTable<reader_external_key_type, internal_key_type, reader_data_type, ?, file_type> /*P*/ Base) {
    raw_svector_ostream OutStream = null;
    try {
      //JAVA: using namespace llvm::support;
      OutStream/*J*/= new raw_svector_ostream(Out);
      {
        Writer $Writer/*J*/= new Writer(little, OutStream);
        
        // Reserve four bytes for the bucket offset.
        $Writer./*<uint32_tint>*/write_uint32(0);
        {
          
          MultiOnDiskHashTable.MergedTable<reader_external_key_type, internal_key_type, reader_data_type, file_type> /*P*/ Merged = (Base != null) ? Base.getMergedTable() : null;
          if (Merged != null) {
            // Write list of overridden files.
            $Writer./*<uint32_tint>*/write_uint32(Merged.Files.size());
            for (final file_type /*const*/ /*&*/ F : Merged.Files)  {
              Info.EmitFileRef(OutStream, F);
            }
            
            // Add all merged entries from Base to the generator.
            for (final std.pair<internal_key_type,  reader_data_type> /*&*/ KV : Merged.Data) {
              if (Native.$not(Gen.contains(KV.first, Info))) {
                Gen.insert(KV.first, Info.ImportData(KV.second), Info);
              }
            }
          } else {
            $Writer./*<uint32_tint>*/write_uint32(0);
          }
        }
      }
      
      // Write the table itself.
      /*uint32_t*/int BucketOffset = Gen.Emit(OutStream, Info);
      
      // Replace the first four bytes with the bucket offset.
      endian.write32le(Out.data(), BucketOffset);
    } finally {
      if (OutStream != null) { OutStream.$destroy(); }
    }
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public void $destroy() {
    this.Gen.$destroy();
  }

  public static interface MultiEmitInfoInterface<internal_key_type, data_type, import_data_from_type, file_type> extends OnDiskChainedHashTableGenerator.EmitInfoInterface<internal_key_type, data_type, file_type> {
    
    public default data_type ImportData(/*file_type*/import_data_from_type data) {
      throw new UnsupportedOperationException("ImportData must be implemented:" + this.getClass() + ". Forgot to remove static?");
    }    
  }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Gen=" + Gen; // NOI18N
  }
}
